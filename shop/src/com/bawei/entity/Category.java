package com.bawei.entity;

//������Ϣ
public class Category {
	private String cid;				//����ID
	private String cname;			//��������
	private String description;		//��������
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", description=" + description + "]";
	}
}
