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
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wordnik.swagger.annotations.Api;
import com.zl.sp.service.IRoleService;
import com.zl.sp.common.BaseController;
import com.zl.sp.common.DataGridInfo;
import com.zl.sp.utils.BeanMapper;
import com.zl.sp.utils.SpTools;
import com.zl.sp.common.Tip;
import com.zl.sp.common.PageFactory;
import com.zl.sp.common.CommonMessage;
import com.zl.sp.persistence.entity.Role;
import com.zl.sp.persistence.entity.User;
import com.zl.sp.model.RoleBO;
/**
 * <p>
 * 角色信息表 前端控制器
 * </p>
 *
 * @author zhangliang
 * @since 2018-04-17
 */
@Api(value="/role")
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {
	@Autowired
    IRoleService service;
    
	@PostMapping(value="/_list",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tip list(@RequestBody(required=false) RoleBO param) {
    	
        EntityWrapper<Role> wrapper = SpTools.createEntityWrapper(param,Role.class); 	
        List<Role> rs = service.selectList(wrapper);
        if(SpTools.isEmpty(rs)) {
        	return succes(CommonMessage.COMMON_MESSAGE_NOTFOUND);
        }
        
        return succes(BeanMapper.mapList(rs, Role.class, RoleBO.class));
    }
    
    @SuppressWarnings("unchecked")
    @PostMapping(value="/_page",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DataGridInfo page(@RequestBody(required=false) RoleBO param) {
    	
        EntityWrapper<Role> wrapper = SpTools.createEntityWrapper(param,Role.class);        
    	Page<Role>  page = service.selectPage(PageFactory.getPageParam(param), wrapper);
    	
    	List<Role> entityList = page.getRecords();
    	if(SpTools.isNotEmpty(entityList)) {
    	  //将实体对象转换成BO
    	  List<RoleBO> boList = BeanMapper.mapList(entityList, Role.class, RoleBO.class);
    	  entityList.clear();
    	  entityList = null;
    	  return super.packForDataGrid(page,boList);
    	}
    	return super.packForDataGrid(page,ListUtils.EMPTY_LIST);
    }
    
    @GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tip get(@PathVariable Integer id) {
        
        Role entity = service.selectById(id);
        if(SpTools.isEmpty(entity)) {
        	return succes(CommonMessage.COMMON_MESSAGE_NOTFOUND);
        }        
        return succes(BeanMapper.map(entity, RoleBO.class));
    }

    @PostMapping(produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tip save(@RequestBody RoleBO param) {		
    	Role role = new Role();
    	role.setRoleName(param.getRoleName());
		Wrapper<Role> userWrapper = SpTools.createEntityWrapper(role);
		role = service.selectOne(userWrapper );
    	if(SpTools.isNotEmpty(role)) {
    		//重名
    		return fail("数据库中已存在该项");
    	}
		//将BO转换为entity对象
	    Role entity = BeanMapper.map(param, Role.class);
		service.insert(entity);
        return super.succes();
    }
    
    @PutMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tip update(@PathVariable Integer id,@RequestBody RoleBO param) {
		
		//将BO转换为entity对象
	    Role entity = BeanMapper.map(param, Role.class);
	    entity.setRoleId(id);	    
		service.updateById(entity);
        return super.succes();
    }

    @DeleteMapping(value = "/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tip delete(@PathVariable Integer id) {
        service.deleteById(id);
        return super.succes();
    }
}