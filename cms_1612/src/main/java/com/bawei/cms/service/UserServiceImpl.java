package com.bawei.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bawei.cms.dao.ChannelDao;
import com.bawei.cms.dao.UserDao;
import com.bawei.cms.domain.Article;
import com.bawei.cms.domain.User;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	
	@Autowired
	private  UserDao  dao;
	

	@Autowired
	private ChannelDao dao2;
	
	@Override
	public void regist(User u) {
		dao.regist(u);
	}
	
	@Override
	public User   login(String username, String password) {
		User user  = dao.login(username, password);
		return user;
	}

	@Override
	public void updatePwd(String username, String newPwd) {
		dao.updatePwd(username, newPwd);
	}

	@Override
	public void update(User u) {
		dao.update(u);
	}

	@Override
	public User findById(int id) {
		return dao.findById(id);
	}

	@Override
	public boolean existUsername(String username) {
		User user  = dao.existUsername(username);
		if(user==null){
			return true;
		}
		return false;
	}

	@Override
	public List<Article> findArticle(Integer user_id) {
		List<Article> list  = dao2.findArticlesByUserId(user_id);
		return list;
	}
}
