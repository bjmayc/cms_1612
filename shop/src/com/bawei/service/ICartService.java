package com.bawei.service;

import com.bawei.util.Cart;

public interface ICartService {

	void add(Cart cart, String pid, int count);

}
