package com.zl.sp.persistence.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangliang
 * @since 2018-04-24
 */
@TableName("sp_resource")
public class Resource extends Model<Resource> {

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

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
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

	@Override
	protected Serializable pkVal() {
		return this.resourceId;
	}

	@Override
	public String toString() {
		return "Resource{" +
			", resourceId=" + resourceId +
			", resourceName=" + resourceName +
			", resourcePid=" + resourcePid +
			", resourcePath=" + resourcePath +
			"}";
	}
}
