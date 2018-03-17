package com.zl.sp.bean;

public class User {
	private Integer userId;

	private String userName;

	private Integer userGender;

	private Integer userAge;

	public User(Integer userId, String userName, Integer userGender, Integer userAge) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userGender = userGender;
		this.userAge = userAge;
	}

	public User() {
		super();
	}

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
		this.userName = userName == null ? null : userName.trim();
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
}