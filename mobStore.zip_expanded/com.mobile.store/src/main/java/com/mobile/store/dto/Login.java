package com.mobile.store.dto;

public class Login {

	private Integer loginId;

	private String loginEmail;

	private String password;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(Integer loginId, String password) {
		super();
		this.loginId = loginId;
		this.password = password;
	}

	public Login(String loginEmail, String password) {
		super();
		this.loginEmail = loginEmail;
		this.password = password;
	}

	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

}
