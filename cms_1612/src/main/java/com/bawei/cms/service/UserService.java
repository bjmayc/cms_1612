package com.bawei.cms.service;

import java.util.List;

import com.bawei.cms.domain.Article;
import com.bawei.cms.domain.User;

public interface UserService {
	//注册
	public    void     regist(User u);
	//登录
	public  User   login(String username,String password);   
	//根据用户名 修改密码  
	public   void updatePwd(String username,String newPwd);
	//根据 id修改   昵称  出生日期等信息
	public  void   update(User u);
	//根据 id查询对应用户
	public  User  findById(int id);
	//查询username用户名 有没有重复的
	public  boolean  existUsername(String username);
	//查询  用户id下 对应发表的文章
	public List<Article> findArticle(Integer id);
	
}
