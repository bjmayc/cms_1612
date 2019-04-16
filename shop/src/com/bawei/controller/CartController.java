package com.bawei.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bawei.service.ICartService;
import com.bawei.util.Cart;


//专门处理购物车相关请求的Controller
@Controller
public class CartController {

	@Autowired
	private ICartService cartService;
	
	//把指定商品和数量加入到购物车中
	@RequestMapping("addToCart")
	public String addToCart( String pid , int count , HttpSession session ){
		
		//从Session域中取得购物车对象
		Cart cart = (Cart)session.getAttribute("cart");
		
		//判断购物车是否为null，如果为空，则说明是第一次访问购物车，需要创建Cart对象
		if( cart == null )
			cart = new Cart();
		//调用业务逻辑，把指定商品和数量，加入到购物车中
		cartService.add( cart , pid , count );
		//购物车保存到Session域中
		session.setAttribute("cart", cart);
		//转跳到购物车页面
		return "cart";
	}
	
	
	//删除购物项
	@RequestMapping("removeFromCart")
	public String removeFromCart( String pid , HttpSession session ){
		//从Session域中取得购物车对象
		Cart cart = (Cart)session.getAttribute("cart");
		//购物车对象不为空，才进行移除操作，否则，什么都不做
		if( cart != null ){
			//从购物车中删除对应的购物项
			cart.remove(pid);
		}
		
		//转跳到购物车页面
		return "cart";
	}

	//删除购物项
	@RequestMapping("clearCart")
	public String clearCart(  HttpSession session ){
		//从Session域中取得购物车对象
		Cart cart = (Cart)session.getAttribute("cart");
		//购物车对象不为空，才进行移除操作，否则，什么都不做
		if( cart != null ){
			//从购物车中删除对应的购物项
			cart.clear();
		}
		
		//转跳到购物车页面
		return "cart";
	}
	
	//显示购物车
	@RequestMapping("showCart")
	public String showCart(  HttpSession session ){
		return "cart";
	}

}
