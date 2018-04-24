/**   
 * @Title: MenuBO.java 
 * @Package com.zl.sp.model 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zl   
 * @date Apr 24, 2018 2:48:48 PM 
 * @version V1.0  
 */
package com.zl.sp.model;

import java.util.ArrayList;
import java.util.List;

import com.zl.sp.persistence.entity.Resource;

/** 
 * @ClassName: MenuBO 
 * @Description: TODO 
 * @author zl
 * @date 18-04-24 2:48:48 PM
 */
public class MenuBO extends Resource{
	/** 
	* @Fields serialVersionUID : (用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -6495444664438487524L;
	
	private List<Resource> secondMenus = new ArrayList<Resource>();
	
	
	
	public MenuBO() {
		super();
	}

	public MenuBO(Resource resource) {
		this.setResourceId(resource.getResourceId());
		this.setResourcePid(resource.getResourcePid());
		this.setResourcePath(resource.getResourcePath());
		this.setResourceName(resource.getResourceName());
	}
	
	public List<Resource> getSecondMenus() {
		return secondMenus;
	}

	public void setSecondMenus(List<Resource> secondMenus) {
		this.secondMenus = secondMenus;
	}

	public void addSecondMenus(Resource resource) {
		this.secondMenus.add(resource);
	}	
}
