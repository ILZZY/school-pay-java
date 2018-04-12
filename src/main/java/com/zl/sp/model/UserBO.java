package com.zl.sp.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.zl.sp.common.MyPage;
import java.io.Serializable;

/**
 * <p>
 * 用户表 业务对象  UserBO
 * </p>
 *
 * @author zhangliang
 * @since 2018-04-09
 */
public class UserBO extends MyPage implements Serializable {
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
	
	
}
