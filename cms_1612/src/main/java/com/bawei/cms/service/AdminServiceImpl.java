package com.bawei.cms.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bawei.cms.dao.AdminDao;
import com.bawei.cms.domain.Admin;
import com.bawei.cms.domain.Article;
import com.bawei.cms.domain.GuangGao;
import com.bawei.cms.util.PageModel;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao dao;
	@Override
	public Admin login(String username, String password) {
		Admin admin = dao.login(username, password);
		return admin;
	}
	@Override
	public List<Article> shenhe(PageModel pm, String title, Integer status, String user, String content, String ts){
		List<Article> list = dao.shenhe(title,status,user,content,ts,pm.getPageRecord(),pm.getPageSize());
		return list;
	}
	@Override
	public int count(String title, Integer status, String user, String content, String ts) {
		return dao.count(title, status, user, content, ts);
	}
	@Override
	public boolean update(Integer id) {
		int c = dao.update(id);
		if(c>0){
			return true;
		}
		return false;
	}
	@Override
	public void add(GuangGao gg) {
		dao.add(gg);
	}
}
