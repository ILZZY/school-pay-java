package com.zl.sp.web.controller;

import java.util.ArrayList;
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
import com.zl.sp.common.BaseController;
import com.zl.sp.common.CommonMessage;
import com.zl.sp.common.DataGridInfo;
import com.zl.sp.common.PageFactory;
import com.zl.sp.common.Tip;
import com.zl.sp.model.MenuBO;
import com.zl.sp.model.UserBO;
import com.zl.sp.persistence.entity.CnnctnRoleResource;
import com.zl.sp.persistence.entity.Resource;
import com.zl.sp.persistence.entity.Role;
import com.zl.sp.persistence.entity.User;
import com.zl.sp.service.ICnnctnRoleResourceService;
import com.zl.sp.service.IResourceService;
import com.zl.sp.service.IRoleService;
import com.zl.sp.service.IUserService;
import com.zl.sp.utils.BeanMapper;
import com.zl.sp.utils.SpTools;
/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zhangliang
 * @since 2018-04-09
 */
@Api(value="/user")
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
	@Autowired
    IUserService service;
	
	@Autowired
    IRoleService roleService;
	
	@Autowired
    IResourceService resourceService;
	
	@Autowired
    ICnnctnRoleResourceService cnnctnRoleResourceService;
	
	@PostMapping(value="/_list",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tip list(@RequestBody(required=false) UserBO param) {
    	
        EntityWrapper<User> wrapper = SpTools.createEntityWrapper(param,User.class); 	
        List<User> rs = service.selectList(wrapper);
        if(SpTools.isEmpty(rs)) {
        	return succes(CommonMessage.COMMON_MESSAGE_NOTFOUND);
        }
        
        return succes(BeanMapper.mapList(rs, User.class, UserBO.class));
    }
    
    @SuppressWarnings("unchecked")
    @PostMapping(value="/_page",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DataGridInfo page(@RequestBody(required=false) UserBO param) {
    	
        EntityWrapper<User> wrapper = SpTools.createEntityWrapper(param,User.class);        
    	Page<User>  page = service.selectPage(PageFactory.getPageParam(param), wrapper);
    	
    	List<User> entityList = page.getRecords();
    	if(SpTools.isNotEmpty(entityList)) {
    	  //将实体对象转换成BO
    	  List<UserBO> boList = BeanMapper.mapList(entityList, User.class, UserBO.class);
    	  entityList.clear();
    	  entityList = null;
    	  return super.packForDataGrid(page,boList);
    	}
    	return super.packForDataGrid(page,ListUtils.EMPTY_LIST);
    }
    
    @GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tip get(@PathVariable Integer id) {
        
        User entity = service.selectById(id);
        if(SpTools.isEmpty(entity)) {
        	return succes(CommonMessage.COMMON_MESSAGE_NOTFOUND);
        }        
        return succes(BeanMapper.map(entity, UserBO.class));
    }

    @PostMapping(value="/_save", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tip save(@RequestBody UserBO param) {		
		User user = new User();
		user.setUserName(param.getUserName());
		Wrapper<User> userWrapper = SpTools.createEntityWrapper(user );
		user = service.selectOne(userWrapper );
    	if(SpTools.isNotEmpty(user)) {
    		//重名
    		return fail("数据库中已存在该项");
    	}
		//将BO转换为entity对象
	    User entity = BeanMapper.map(param, User.class);
		service.insert(entity);
        return super.succes();
    }
    
    @PutMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tip update(@PathVariable Integer id,@RequestBody UserBO param) {
		
		//将BO转换为entity对象
	    User entity = BeanMapper.map(param, User.class);
	    entity.setUserId(id);	    
		service.updateById(entity);
        return super.succes();
    }

    @DeleteMapping(value = "/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tip delete(@PathVariable Integer id) {
        service.deleteById(id);
        
        return super.succes();
    }
    
    @PostMapping(value="/_login",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tip login(@RequestBody UserBO param) {
    	User user = new User();
    	user.setUserName(param.getUserName());
		EntityWrapper<User> userWrapper = SpTools.createEntityWrapper(user);
		user = service.selectOne(userWrapper);
        if(SpTools.isEmpty(user)) {
        	return fail("未找到该用户");
        }
        if(!param.getUserPassword().equals(user.getUserPassword())) {
        	return fail("用户名或密码错误");
        }
        
        Role role = findRoleByUser(user);
        List<Resource> resources = null;
        List<MenuBO> result = null;
        if(SpTools.isNotEmpty(role)) {
        	resources = findResourceByRole(role);
        }
        if(SpTools.isNotEmpty(resources)) {
    		result = convertResources(resources);
    	}
        
        return succes("登录成功", result);
    }
    
    @PostMapping(value="/_resource/{roleId}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Tip resource(@PathVariable Integer roleId) {
    	List<Resource> list = new ArrayList<Resource>(); 
    	CnnctnRoleResource entity = new CnnctnRoleResource();
    	entity.setCnnctnRoleId(roleId);
		Wrapper<CnnctnRoleResource> wrapper = SpTools.createEntityWrapper(entity );
	 	List<CnnctnRoleResource> roleResources=cnnctnRoleResourceService.selectList(wrapper);
	 	
	 	Resource resourceTmp = new Resource();
	 	for (CnnctnRoleResource roleResource : roleResources) {
	 		Integer resourceId = roleResource.getCnnctnResourceId();
	 		resourceTmp = resourceService.selectById(resourceId);
	 		list.add(resourceTmp);
		}
	 	
	 	List<MenuBO> result = convertResources(list);
	 	
        return succes(result);
    }
    
    private Role findRoleByUser(User user) {
    	Role entity = new Role();
    	entity.setRoleId(user.getUserRoleId());
		Wrapper<Role> wrapper = SpTools.createEntityWrapper(entity);
		entity = roleService.selectOne(wrapper);
		return entity;    	
    }
    
    private List<Resource> findResourceByRole(Role role) {
    	List<Resource> list = new ArrayList<Resource>(); 
    	CnnctnRoleResource entity = new CnnctnRoleResource();
    	entity.setCnnctnRoleId(role.getRoleId());
		Wrapper<CnnctnRoleResource> wrapper = SpTools.createEntityWrapper(entity );
	 	List<CnnctnRoleResource> roleResources=cnnctnRoleResourceService.selectList(wrapper);
	 	
	 	Resource resourceTmp = new Resource();
	 	for (CnnctnRoleResource roleResource : roleResources) {
	 		Integer resourceId = roleResource.getCnnctnResourceId();
	 		resourceTmp = resourceService.selectById(resourceId);
	 		list.add(resourceTmp);
		}
		return list;    	
    }
    
    private List<MenuBO> convertResources(List<Resource> resources) {
    	List<MenuBO> firstMenus = new ArrayList<MenuBO>();
    	
    	for (Resource resource : resources) {
    		int pid = resource.getResourcePid();
			if(pid == 1) {
				MenuBO menu = new MenuBO(resource);
				firstMenus.add(menu);
				menu = null;
			}
		}
    	for (Resource resource : resources) {
			int pid = resource.getResourcePid();
			if((pid != 1) && (pid != 0)) {
				for(MenuBO firstMenu : firstMenus) {
					if(firstMenu.getResourceId() == pid) {
						firstMenu.addSecondMenus(resource);
					}
				}
			}
		}
		return firstMenus;
    }
}