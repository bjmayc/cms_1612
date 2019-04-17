package com.bawei.cms.domain;

import java.io.Serializable;

//文章的栏目 
public class Channel implements Serializable{
	private int   id;
	private String name;
	private String description;
	private String icon;
	
	public Channel() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
