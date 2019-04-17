package com.bawei.cms.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bawei.cms.domain.Admin;
import com.bawei.cms.domain.Article;
import com.bawei.cms.domain.GuangGao;

public interface AdminDao {
	public Admin login(@Param("username")String username,@Param("password")String password);
	
	public List<Article>  shenhe(@Param("title")String title,@Param("status")Integer  status,@Param("user")String user,@Param("content")String content,@Param("ts")String ts,@Param("from")int from,@Param("pageSize")int pageSize);
	public  int count(@Param("title")String title,@Param("status")Integer  status,@Param("user")String user,@Param("content")String content,@Param("ts")String ts);

	public int update(@Param("id") Integer id);
	//添加广告 
	public void add(@Param("gg") GuangGao gg);
}
