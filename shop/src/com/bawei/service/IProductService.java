package com.bawei.service;

import java.util.List;

import com.bawei.entity.Product;
import com.bawei.util.PageModel;

public interface IProductService {

	List<Product> findHotProducts();

	List<Product> findNewProducts();

	int count(String cid);

	List<Product> findPage(PageModel pm, String cid);

	Product findByPid(String pid);

}
