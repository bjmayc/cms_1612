package com.bawei.cms.dao;

import org.apache.ibatis.annotations.Param;

import com.bawei.cms.domain.User;

public interface UserDao {
	//注册
	public   void   regist(@Param("u") User u);
	//登录
	public  User login(@Param("username")String username,@Param("password")String password);
	//修改密码
	public void updatePwd(@Param("username")String username,@Param("newpwd")String newpwd);
	//修改别的信息 
	public  void update(@Param("u")User u);
	//根据 id查询 对应得用户
	public  User findById(@Param("id") int id);
	
	public User  existUsername(@Param("username") String username);
}
