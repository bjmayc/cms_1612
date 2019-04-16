package com.bawei.dao;

import org.apache.ibatis.annotations.Param;

import com.bawei.entity.User;

public interface IUserDao {
	void save(@Param("user") User user);

	void updateState(@Param("code") String code);

	User findUserByUsername(@Param("username")String username);
}
