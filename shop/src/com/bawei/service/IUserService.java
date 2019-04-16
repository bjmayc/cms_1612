package com.bawei.service;

import com.bawei.entity.User;

public interface IUserService {

	void save(User user);

	void updateState(String code);

	boolean login(User user);
}
