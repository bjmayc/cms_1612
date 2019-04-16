package com.bawei.entity;

import java.util.Date;

public class User {
	//设置静态常量，说明用户的状态 ：0为未激活，1为已激活
	public static final int USER_STATE_ACTIVE = 1;
	public static final int USER_STATE_UNACTIVE = 0;
	
	private String uid;			//用户ID
	private String username;	//用户名（唯一）
	private String password;	//密码
	private String name;		//姓名
	private String email;		//邮箱
	private String telephone;	//电话
	private Date birthday;		//生日
	private String sex;			//性别
	private int state;			//状态（已激活：1、未激活：0）
	private String code;		//激活码
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", name=" + name + ", email="
				+ email + ", telephone=" + telephone + ", birthday=" + birthday + ", sex=" + sex + ", state=" + state
				+ ", code=" + code + "]";
	}
	
}
