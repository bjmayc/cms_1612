package com.bawei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bawei.dao.IUserDao;
import com.bawei.entity.User;
import com.bawei.util.MailUtils;
import com.bawei.util.UUIDUtils;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao dao;
	@Override
	public void save(User user) {
		user.setUid(UUIDUtils.generateID());
		user.setPassword(UUIDUtils.md5(user.getPassword()));
		user.setCode(UUIDUtils.generateCode());
		user.setState(User.USER_STATE_UNACTIVE);
		dao.save(user);
		//·¢ÓÊ¼þ
		MailUtils.sendMail(user.getEmail(),user.getCode());
	}
	
	public void setDao(IUserDao dao) {
		this.dao = dao;
	}

	@Override
	public void updateState(String code) {
		dao.updateState(code);
	}

	@Override
	public boolean login(User user) {
		User u = dao.findUserByUsername(user.getUsername());
		if(u!=null){
			if(u.getPassword().equals(UUIDUtils.md5(user.getPassword())) && u.getState()==User.USER_STATE_ACTIVE){
				return true;
			}
		}
		return false;
	}
}
