package com.bawei.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bawei.dao.ICategoryDao;
import com.bawei.entity.Category;

@Service
public class CategoreServiceImpl implements ICategoreService {
	
	@Autowired
	private ICategoryDao dao;
	@Override
	public List<Category> findAll() {
		return dao.findAll();
	}

}
