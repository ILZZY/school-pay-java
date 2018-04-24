package com.zl.sp.persistence.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author zhangliang
 * @since 2018-04-24
 */
@TableName("sp_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 标识id
     */
	@TableId(value="user_id", type= IdType.AUTO)
	private Integer userId;
    /**
     * 用户名
     */
	@TableField("user_name")
	private String userName;
    /**
     * 用户性别：0为男，1为女
     */
	@TableField("user_gender")
	private Integer userGender;
	@TableField("user_age")
	private Integer userAge;
    /**
     * 用户密码
     */
	@TableField("user_password")
	private String userPassword;
	@TableField("user_address")
	private String userAddress;
	@TableField("user_email")
	private String userEmail;
	@TableField("user_full_name")
	private String userFullName;
    /**
     * 用户角色id
     */
	@TableField("user_role_id")
	private Integer userRoleId;


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserGender() {
		return userGender;
	}

	public void setUserGender(Integer userGender) {
		this.userGender = userGender;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Override
	protected Serializable pkVal() {
		return this.userId;
	}

	@Override
	public String toString() {
		return "User{" +
			", userId=" + userId +
			", userName=" + userName +
			", userGender=" + userGender +
			", userAge=" + userAge +
			", userPassword=" + userPassword +
			", userAddress=" + userAddress +
			", userEmail=" + userEmail +
			", userFullName=" + userFullName +
			", userRoleId=" + userRoleId +
			"}";
	}
}
