package com.zl.sp.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.zl.sp.common.MyPage;
import java.io.Serializable;

/**
 * <p>
 *  业务对象  ResourceBO
 * </p>
 *
 * @author zhangliang
 * @since 2018-04-24
 */
public class ResourceBO extends MyPage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
     * 资源标识符
     */
    @TableId("resource_id")
	private Integer resourceId;
    /**
     * 菜单名称
     */
	@TableField("resource_name")
	private String resourceName;
    /**
     * 父级菜单id
     */
	@TableField("resource_pid")
	private Integer resourcePid;
    /**
     * 资源路径
     */
	@TableField("resource_path")
	private String resourcePath;
	public Integer getResourceId() {
		return resourceId;
	}
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	public Integer getResourcePid() {
		return resourcePid;
	}
	public void setResourcePid(Integer resourcePid) {
		this.resourcePid = resourcePid;
	}
	public String getResourcePath() {
		return resourcePath;
	}
	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	
}
