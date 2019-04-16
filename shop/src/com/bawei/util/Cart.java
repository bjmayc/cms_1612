package com.bawei.util;

import java.util.HashMap;
import java.util.Map;

import com.bawei.entity.Product;

//���ﳵ
public class Cart {

	private Map<String,CartItem> map = new HashMap<String,CartItem>();	//�������й�����ļ��ϣ�Ϊ�˷����������PIDΪKey
	private double total;				//�ܼƣ� cartItem.subtotal�ĺ� ��

	//���ﳵ��Ҫ�ṩ�ķ�����
	//��ӹ�������ﳵ��
	public void add( Product product , int count ){
		
		//�жϴ���Ʒ�ڹ��ﳵ���Ƿ��Ѵ���
		if( map.containsKey( product.getPid() ) ){
			//�Ѵ��ڣ����������ۼ�
			CartItem item = map.get(product.getPid());
			//���е���Ʒ���������ϱ��μ��빺�ﳵ������
			int c = item.getCount() + count;
			//���ۼӺ��ֵ��ע�뵽��������
			item.setCount( c );
		}else{
			//�����ڣ������µĹ�������浽Map��
			CartItem item = new CartItem( product , count );
			map.put( product.getPid() , item);
		}
	}
	
	//�ӹ��ﳵ��ɾ��������
	public void remove( String pid ){
		map.remove(pid);
	}
	
	//��չ��ﳵ
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
		//����Map�����е�ÿ������������ۼ�
		for (String pid : map.keySet()) {
			this.total += map.get(pid).getSubtotal();
		}
		
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
