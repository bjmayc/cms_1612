package com.bawei.util;

import com.bawei.entity.Product;

//购物项
public class CartItem {
	private Product product;	//要买哪个商品
	private int count;			//要买的数量
	private double subtotal;	//小计（商品单价*数量 = product.shopPrice*count）

	public CartItem(){}
	
	public CartItem(Product product, int count) {
		super();
		this.product = product;
		this.count = count;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		//一个购物项的小计=商品单价*数量
		this.subtotal = product.getShopPrice() * count;
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
}
