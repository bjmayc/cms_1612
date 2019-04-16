package com.bawei.util;

import java.util.HashMap;
import java.util.Map;

import com.bawei.entity.Product;

//购物车
public class Cart {

	private Map<String,CartItem> map = new HashMap<String,CartItem>();	//保存所有购物项的集合，为了方便操作，以PID为Key
	private double total;				//总计（ cartItem.subtotal的和 ）

	//购物车需要提供的方法：
	//添加购物项到购物车中
	public void add( Product product , int count ){
		
		//判断此商品在购物车中是否已存在
		if( map.containsKey( product.getPid() ) ){
			//已存在，进行数量累加
			CartItem item = map.get(product.getPid());
			//已有的商品数量，加上本次加入购物车的数量
			int c = item.getCount() + count;
			//把累加后的值，注入到购物项中
			item.setCount( c );
		}else{
			//不存在，创建新的购物项并保存到Map中
			CartItem item = new CartItem( product , count );
			map.put( product.getPid() , item);
		}
	}
	
	//从购物车中删除购物项
	public void remove( String pid ){
		map.remove(pid);
	}
	
	//清空购物车
	public void clear(){
		map.clear();
	}
	
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	public double getTotal() {
		this.total = 0;
		//遍历Map集合中的每个购物项，进行累加
		for (String pid : map.keySet()) {
			this.total += map.get(pid).getSubtotal();
		}
		
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
