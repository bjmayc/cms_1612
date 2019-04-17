package com.bawei.cms.domain;

//广告类
public class GuangGao {
	private  int id;
	private String title;
	private String url;//点击图片 跳转的网址
	private String picture;
	
	
	
	public GuangGao() {
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getPicture() {
		return picture;
	}


	
	public void setPicture(String picture) {
		this.picture = picture;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GuangGao other = (GuangGao) obj;
		if (id != other.id)
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "GuangGao [id=" + id + ", title=" + title + ", url=" + url + ", picture=" + picture + "]";
	}
	
}
