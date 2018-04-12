package com.zl.sp.persistence.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import java.util.Date;
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
 * @since 2018-04-05
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
     * 角色生成时间
     */
	@TableField("role_generate_time")
	private Date roleGenerateTime;


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

	public Date getRoleGenerateTime() {
		return roleGenerateTime;
	}

	public void setRoleGenerateTime(Date roleGenerateTime) {
		this.roleGenerateTime = roleGenerateTime;
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
			", roleGenerateTime=" + roleGenerateTime +
			"}";
	}
}
