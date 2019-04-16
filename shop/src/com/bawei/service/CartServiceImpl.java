package com.bawei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bawei.dao.IProductDao;
import com.bawei.entity.Product;
import com.bawei.util.Cart;

@Service
public class CartServiceImpl implements ICartService {
	@Autowired
	private IProductDao dao;
	@Override
	public void add(Cart cart, String pid, int count) {
		Product product = dao.findByPid(pid);
		cart.add(product, count);
	}
}
