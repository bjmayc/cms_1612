package com.bawei.cms.domain;

//管理员账户类 (后台登录)
public class Admin {

	private String admin_username;//管理员用户名
	private String admin_password;//管理员密码
	
	public Admin() {
	}

	public String getAdmin_username() {
		return admin_username;
	}

	public void setAdmin_username(String admin_username) {
		this.admin_username = admin_username;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
}
