package com.zl.sp.web.controller;

import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wordnik.swagger.annotations.Api;
import com.zl.sp.service.IOrderService;
import com.zl.sp.common.BaseController;
import com.zl.sp.common.DataGridInfo;
import com.zl.sp.utils.BeanMapper;
import com.zl.sp.utils.SpTools;
import com.zl.sp.common.Tip;
import com.zl.sp.common.PageFactory;
import com.zl.sp.common.CommonMessage;
import com.zl.sp.persistence.entity.Order;
import com.zl.sp.model.OrderBO;
/**
 * <p>
 * 订单信息 前端控制器
 * </p>
 *
 * @author zhangliang
 * @since 2018-04-13
 */
@Api(value="/order")
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {
	@Autowired
    IOrderService service;
    
	@PostMapping(value="/_list",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tip list(@RequestBody(required=false) OrderBO param) {
    	
        EntityWrapper<Order> wrapper = SpTools.createEntityWrapper(param,Order.class); 	
        List<Order> rs = service.selectList(wrapper);
        if(SpTools.isEmpty(rs)) {
        	return succes(CommonMessage.COMMON_MESSAGE_NOTFOUND);
        }
        
        return succes(BeanMapper.mapList(rs, Order.class, OrderBO.class));
    }
    
    @SuppressWarnings("unchecked")
    @PostMapping(value="/_page",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DataGridInfo page(@RequestBody(required=false) OrderBO param) {
    	
        EntityWrapper<Order> wrapper = SpTools.createEntityWrapper(param,Order.class);        
    	Page<Order>  page = service.selectPage(PageFactory.getPageParam(param), wrapper);
    	
    	List<Order> entityList = page.getRecords();
    	if(SpTools.isNotEmpty(entityList)) {
    	  //将实体对象转换成BO
    	  List<OrderBO> boList = BeanMapper.mapList(entityList, Order.class, OrderBO.class);
    	  entityList.clear();
    	  entityList = null;
    	  return super.packForDataGrid(page,boList);
    	}
    	return super.packForDataGrid(page,ListUtils.EMPTY_LIST);
    }
    
    @SuppressWarnings("unchecked")
    @PostMapping(value="/_pageWithUserName/{userName}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DataGridInfo pageWithUserName(@RequestBody(required=false) OrderBO param, @PathVariable String userName) {
    	param.setOrderUserName(userName);
        EntityWrapper<Order> wrapper = SpTools.createEntityWrapper(param,Order.class);        
    	Page<Order>  page = service.selectPage(PageFactory.getPageParam(param), wrapper);
    	
    	List<Order> entityList = page.getRecords();
    	if(SpTools.isNotEmpty(entityList)) {
    	  //将实体对象转换成BO
    	  List<OrderBO> boList = BeanMapper.mapList(entityList, Order.class, OrderBO.class);
    	  entityList.clear();
    	  entityList = null;
    	  return super.packForDataGrid(page,boList);
    	}
    	return super.packForDataGrid(page,ListUtils.EMPTY_LIST);
    }
    
    @GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tip get(@PathVariable Integer id) {
        
        Order entity = service.selectById(id);
        if(SpTools.isEmpty(entity)) {
        	return succes(CommonMessage.COMMON_MESSAGE_NOTFOUND);
        }        
        return succes(BeanMapper.map(entity, OrderBO.class));
    }

    @PostMapping(produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tip save(@RequestBody OrderBO param) {		
		
		//将BO转换为entity对象
	    Order entity = BeanMapper.map(param, Order.class);
		service.insert(entity);
        return super.succes();
    }
    
    @PutMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tip update(@PathVariable Integer id,@RequestBody OrderBO param) {
		
		//将BO转换为entity对象
	    Order entity = BeanMapper.map(param, Order.class);
	    entity.setOrderId(id);	    
		service.updateById(entity);
        return super.succes();
    }

    @DeleteMapping(value = "/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tip delete(@PathVariable Integer id) {
        service.deleteById(id);
        return super.succes();
    }
}