package com.bawei.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bawei.entity.Product;

public interface IProductDao {
	List<Product> findHotProducts();
	List<Product> findNewProducts();
	List<Product> findPage(@Param("from")int from, @Param("pageSize") int pageSize, @Param("cid")String cid);
	int count(@Param("cid")String cid);
	Product findByPid(@Param("pid")String pid);
}
