package com.bawei.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bawei.dao.IProductDao;
import com.bawei.entity.Product;
import com.bawei.util.PageModel;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private IProductDao dao;
	
	@Override
	public List<Product> findHotProducts() {
		return dao.findHotProducts();
	}

	@Override
	public List<Product> findNewProducts() {
		return dao.findNewProducts();
	}

	@Override
	public int count(String cid) {
		return dao.count(cid);
	}

	@Override
	public List<Product> findPage(PageModel pm, String cid) {
		return dao.findPage(pm.getPageRecord(),pm.getPageSize(),cid);
	}

	@Override
	public Product findByPid(String pid) {
		return dao.findByPid(pid);
		
	}

}
