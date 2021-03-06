package com.zl.sp.persistence.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色信息表
 * </p>
 *
 * @author zhangliang
 * @since 2018-04-24
 */
@TableName("sp_role")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
	@TableId(value="role_id", type= IdType.AUTO)
	private Integer roleId;
    /**
     * 角色标识名称
     */
	@TableField("role_name")
	private String roleName;
    /**
     * 角色描述
     */
	@TableField("role_desc")
	private String roleDesc;
    /**
     * 角色对应的资源
     */
	@TableField("role_resources")
	private String roleResources;


	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getRoleResources() {
		return roleResources;
	}

	public void setRoleResources(String roleResources) {
		this.roleResources = roleResources;
	}

	@Override
	protected Serializable pkVal() {
		return this.roleId;
	}

	@Override
	public String toString() {
		return "Role{" +
			", roleId=" + roleId +
			", roleName=" + roleName +
			", roleDesc=" + roleDesc +
			", roleResources=" + roleResources +
			"}";
	}
}
