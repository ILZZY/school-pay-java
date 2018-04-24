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
import com.zl.sp.service.IResourceService;
import com.zl.sp.common.BaseController;
import com.zl.sp.common.DataGridInfo;
import com.zl.sp.utils.BeanMapper;
import com.zl.sp.utils.SpTools;
import com.zl.sp.common.Tip;
import com.zl.sp.common.PageFactory;
import com.zl.sp.common.CommonMessage;
import com.zl.sp.persistence.entity.Resource;
import com.zl.sp.model.ResourceBO;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangliang
 * @since 2018-04-24
 */
@Api(value="/resource")
@RestController
@RequestMapping("/resource")
public class ResourceController extends BaseController {
	@Autowired
    IResourceService service;
    
	@PostMapping(value="/_list",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tip list(@RequestBody(required=false) ResourceBO param) {
    	
        EntityWrapper<Resource> wrapper = SpTools.createEntityWrapper(param,Resource.class); 	
        List<Resource> rs = service.selectList(wrapper);
        if(SpTools.isEmpty(rs)) {
        	return succes(CommonMessage.COMMON_MESSAGE_NOTFOUND);
        }
        
        return succes(BeanMapper.mapList(rs, Resource.class, ResourceBO.class));
    }
    
    @SuppressWarnings("unchecked")
    @PostMapping(value="/_page",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DataGridInfo page(@RequestBody(required=false) ResourceBO param) {
    	
        EntityWrapper<Resource> wrapper = SpTools.createEntityWrapper(param,Resource.class);        
    	Page<Resource>  page = service.selectPage(PageFactory.getPageParam(param), wrapper);
    	
    	List<Resource> entityList = page.getRecords();
    	if(SpTools.isNotEmpty(entityList)) {
    	  //将实体对象转换成BO
    	  List<ResourceBO> boList = BeanMapper.mapList(entityList, Resource.class, ResourceBO.class);
    	  entityList.clear();
    	  entityList = null;
    	  return super.packForDataGrid(page,boList);
    	}
    	return super.packForDataGrid(page,ListUtils.EMPTY_LIST);
    }
    
    @GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tip get(@PathVariable Integer id) {
        
        Resource entity = service.selectById(id);
        if(SpTools.isEmpty(entity)) {
        	return succes(CommonMessage.COMMON_MESSAGE_NOTFOUND);
        }        
        return succes(BeanMapper.map(entity, ResourceBO.class));
    }

    @PostMapping(produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tip save(@RequestBody ResourceBO param) {		
		
		//将BO转换为entity对象
	    Resource entity = BeanMapper.map(param, Resource.class);
		service.insert(entity);
        return super.succes();
    }
    
    @PutMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tip update(@PathVariable Integer id,@RequestBody ResourceBO param) {
		
		//将BO转换为entity对象
	    Resource entity = BeanMapper.map(param, Resource.class);
	    entity.setResourceId(id);	    
		service.updateById(entity);
        return super.succes();
    }

    @DeleteMapping(value = "/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tip delete(@PathVariable Integer id) {
        service.deleteById(id);
        return super.succes();
    }
}