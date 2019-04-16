package com.bawei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bawei.entity.Product;
import com.bawei.service.IProductService;
import com.bawei.service.ProductServiceImpl;
import com.bawei.util.PageModel;

@Controller
public class ProductController {
	
	@Autowired
	private IProductService  productService;
	
	@RequestMapping("showProductsByCidByPage")
	public  String showProductsByCidByPage(@RequestParam(defaultValue="1")String cpage,@RequestParam(defaultValue="") String cid,Model model){
		PageModel  pm  = new PageModel(cpage,productService.count(cid),2);
		model.addAttribute("pm", pm);
		model.addAttribute("cpage", cpage);
		model.addAttribute("cid", cid);
		List<Product>  products = productService.findPage(pm,cid);
		model.addAttribute("products", products);
		return "product_list";
	}
	
	@RequestMapping("showProduct")
	public String  showProduct(String pid,Model model){
		Product product = productService.findByPid(pid);
		model.addAttribute("product", product);
		return "product_info";
	}
	
	
}
