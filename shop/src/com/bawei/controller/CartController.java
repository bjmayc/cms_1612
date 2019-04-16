package com.bawei.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bawei.service.ICartService;
import com.bawei.util.Cart;


//ר�Ŵ����ﳵ��������Controller
@Controller
public class CartController {

	@Autowired
	private ICartService cartService;
	
	//��ָ����Ʒ���������뵽���ﳵ��
	@RequestMapping("addToCart")
	public String addToCart( String pid , int count , HttpSession session ){
		
		//��Session����ȡ�ù��ﳵ����
		Cart cart = (Cart)session.getAttribute("cart");
		
		//�жϹ��ﳵ�Ƿ�Ϊnull�����Ϊ�գ���˵���ǵ�һ�η��ʹ��ﳵ����Ҫ����Cart����
		if( cart == null )
			cart = new Cart();
		//����ҵ���߼�����ָ����Ʒ�����������뵽���ﳵ��
		cartService.add( cart , pid , count );
		//���ﳵ���浽Session����
		session.setAttribute("cart", cart);
		//ת�������ﳵҳ��
		return "cart";
	}
	
	
	//ɾ��������
	@RequestMapping("removeFromCart")
	public String removeFromCart( String pid , HttpSession session ){
		//��Session����ȡ�ù��ﳵ����
		Cart cart = (Cart)session.getAttribute("cart");
		//���ﳵ����Ϊ�գ��Ž����Ƴ�����������ʲô������
		if( cart != null ){
			//�ӹ��ﳵ��ɾ����Ӧ�Ĺ�����
			cart.remove(pid);
		}
		
		//ת�������ﳵҳ��
		return "cart";
	}

	//ɾ��������
	@RequestMapping("clearCart")
	public String clearCart(  HttpSession session ){
		//��Session����ȡ�ù��ﳵ����
		Cart cart = (Cart)session.getAttribute("cart");
		//���ﳵ����Ϊ�գ��Ž����Ƴ�����������ʲô������
		if( cart != null ){
			//�ӹ��ﳵ��ɾ����Ӧ�Ĺ�����
			cart.clear();
		}
		
		//ת�������ﳵҳ��
		return "cart";
	}
	
	//��ʾ���ﳵ
	@RequestMapping("showCart")
	public String showCart(  HttpSession session ){
		return "cart";
	}

}
