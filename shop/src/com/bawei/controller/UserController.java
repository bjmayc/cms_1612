package com.bawei.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bawei.entity.Category;
import com.bawei.entity.Product;
import com.bawei.entity.User;
import com.bawei.service.ICategoreService;
import com.bawei.service.IProductService;
import com.bawei.service.IUserService;
import com.bawei.util.Constant;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	
	@Autowired
	private IProductService productService;
	
	
	@Autowired
	private ICategoreService categoreService;
	
	
	
	
	@RequestMapping("toRegister")
	public String  toRegister(){
		
		return "register";
	}
	
	//�������ڸ�ʽ
	@InitBinder
	public void InitBinder(WebDataBinder wdb){
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		wdb.registerCustomEditor(Date.class, new CustomDateEditor(sdf,true));
	}
	
	
	@RequestMapping("register")
	public  String register(User user,Model model){
		userService.save(user);
		model.addAttribute("msg","��ϲ���ɹ�ע��ɰ�ά�̳ǵĻ�Ա��������֤�ʼ��еĳ�������ɼ��");
		return "info";
	}
	
	@RequestMapping("active")
	public  String active(String code,Model model){
		userService.updateState(code);
		model.addAttribute("msg", "����ɹ��������ڿ��Ե�¼��ά�̳��ˡ�");
		return "info";
	}
	
	@RequestMapping("toLogin")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping("index")
	public String  index(Model model,HttpServletRequest request){
		//��������
		List<Product> list2 = productService.findHotProducts();
		model.addAttribute("hots",list2);
		//���µ�
		List<Product> list3 = productService.findNewProducts();
		model.addAttribute("news", list3);
		
		ServletContext sc = request.getServletContext();
		List<Category> allCategorys= (List<Category> )sc.getAttribute("allCategorys");
		if(allCategorys==null){
			allCategorys = categoreService.findAll();
			sc.setAttribute("allCategorys", allCategorys);
		}
		return "index";
	}
	
	
	
	@RequestMapping("login")
	public  String login(User user,Model model,HttpSession session){
		boolean flag = userService.login(user);
		if(flag){
			session.setAttribute(Constant.CURRENT_USER, user);
			return "redirect:index.do";
		}
		model.addAttribute(Constant.LOGIN_ERROR, "�û��������������!");
		return "login";
	}
	
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	
	public void setCategoreService(ICategoreService categoreService) {
		this.categoreService = categoreService;
	}
}
