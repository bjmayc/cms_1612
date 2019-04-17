package com.bawei.cms.service;

import java.sql.Timestamp;
import java.util.List;

import com.bawei.cms.domain.Admin;
import com.bawei.cms.domain.Article;
import com.bawei.cms.domain.GuangGao;
import com.bawei.cms.util.PageModel;

public interface AdminService {
	//登录
	public Admin login(String username,String password);
	//审核
	public List<Article> shenhe(PageModel pm,String title,Integer status,String user,String content,String ts);
	public int count(String title,Integer status,String user,String content,String ts);
	public boolean update(Integer id);
	//添加广告
	public void add(GuangGao gg);
}
