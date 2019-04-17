package com.bawei.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bawei.cms.domain.Admin;
import com.bawei.cms.domain.Article;
import com.bawei.cms.domain.GuangGao;
import com.bawei.cms.service.AdminService;
import com.bawei.cms.util.PageModel;
@Controller
public class AdminController {
	
	
	@Autowired
	private AdminService as;
	
	@RequestMapping("adminLogin.do")
	public String login(String username,String password,HttpSession session,Model model){
		Admin admin  = as.login(username, password);
		if(admin==null){
			model.addAttribute("admin_error","管理员账户错误");
			return "admin";
		}else{
			session.setAttribute("admin",admin);
			return "forward:shenhe.do";
		}
		
	}
	
	
	
	@RequestMapping("shenhe.do")
	public String  shenhe(Model model,String cpage,String title,Integer status,String user,String content,String ts){
		System.out.println("status="+status);
		System.out.println("title="+title);
		System.out.println("content="+content);
		System.out.println("ts="+ts);
		System.out.println("user="+user);
		System.out.println("cpage="+cpage);
		PageModel pm = new PageModel(cpage, as.count(title, status, user, content, ts), 2);
		List<Article> list=as.shenhe(pm, title, status, user, content, ts);
		model.addAttribute("list1",list);
		model.addAttribute("pm",pm);
		model.addAttribute("title", title);
		model.addAttribute("status", status);
		model.addAttribute("content", content);
		model.addAttribute("user", user);
		model.addAttribute("ts", ts);
		return "adminList";
	}
	
	@RequestMapping("tongguo.do")
	@ResponseBody
	public boolean   tongguo(Integer id){
		boolean flag = as.update(id);
		return flag;
	}
	
	
	@RequestMapping("add.do")
	public   String add(MultipartFile mf,GuangGao gg,HttpSession session) throws IllegalStateException, IOException{
		ServletContext application = session.getServletContext();
		//根据 开发的时候的 逻辑路径    获取 实际 部署到 服务器的 物理路径 
		String realPath = application.getRealPath("/img");
		String filename = mf.getOriginalFilename();
		String   uploadPath = realPath+"/"+filename;
		System.out.println("uploadPath="+uploadPath);
		//封装成File对象 
		File f = new File(uploadPath);
		//上传 
		mf.transferTo(f);
		//将广告信息  添加到 数据库
		gg.setPicture(filename);
		as.add(gg);
		return "forward:shenhe.do";
	}
}
