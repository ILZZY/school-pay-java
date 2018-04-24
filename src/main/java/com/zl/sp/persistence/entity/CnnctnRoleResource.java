package com.zl.sp.persistence.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("sp_cnnctn_role_resource")
public class CnnctnRoleResource extends Model<CnnctnRoleResource> {

    private static final long serialVersionUID = 1L;

    /**
     * 关联id
     */
	@TableId(value="cnnctn_id", type= IdType.AUTO)
	private Integer cnnctnId;
    /**
     * 角色id
     */
	@TableField("cnnctn_role_id")
	private Integer cnnctnRoleId;
    /**
     * 资源id
     */
	@TableField("cnnctn_resource_id")
	private Integer cnnctnResourceId;


	public Integer getCnnctnId() {
		return cnnctnId;
	}

	public void setCnnctnId(Integer cnnctnId) {
		this.cnnctnId = cnnctnId;
	}

	public Integer getCnnctnRoleId() {
		return cnnctnRoleId;
	}

	public void setCnnctnRoleId(Integer cnnctnRoleId) {
		this.cnnctnRoleId = cnnctnRoleId;
	}

	public Integer getCnnctnResourceId() {
		return cnnctnResourceId;
	}

	public void setCnnctnResourceId(Integer cnnctnResourceId) {
		this.cnnctnResourceId = cnnctnResourceId;
	}

	@Override
	protected Serializable pkVal() {
		return this.cnnctnId;
	}

	@Override
	public String toString() {
		return "CnnctnRoleResource{" +
			", cnnctnId=" + cnnctnId +
			", cnnctnRoleId=" + cnnctnRoleId +
			", cnnctnResourceId=" + cnnctnResourceId +
			"}";
	}
}
