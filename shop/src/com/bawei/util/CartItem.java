package com.bawei.util;

import com.bawei.entity.Product;

//������
public class CartItem {
	private Product product;	//Ҫ���ĸ���Ʒ
	private int count;			//Ҫ�������
	private double subtotal;	//С�ƣ���Ʒ����*���� = product.shopPrice*count��

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
		//һ���������С��=��Ʒ����*����
		this.subtotal = product.getShopPrice() * count;
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
}
