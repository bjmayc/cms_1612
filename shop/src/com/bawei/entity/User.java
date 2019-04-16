package com.bawei.entity;

import java.util.Date;

public class User {
	//���þ�̬������˵���û���״̬ ��0Ϊδ���1Ϊ�Ѽ���
	public static final int USER_STATE_ACTIVE = 1;
	public static final int USER_STATE_UNACTIVE = 0;
	
	private String uid;			//�û�ID
	private String username;	//�û�����Ψһ��
	private String password;	//����
	private String name;		//����
	private String email;		//����
	private String telephone;	//�绰
	private Date birthday;		//����
	private String sex;			//�Ա�
	private int state;			//״̬���Ѽ��1��δ���0��
	private String code;		//������
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
