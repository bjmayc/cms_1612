package com.bawei.cms.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bawei.cms.domain.Article;
import com.bawei.cms.domain.Category;
import com.bawei.cms.domain.Channel;
import com.bawei.cms.domain.User;
import com.bawei.cms.service.ChannelService;
import com.bawei.cms.util.PageModel;

@Controller
public class ChannelController {
	@Autowired
	private ChannelService cs;
	
	//查询所有的栏目   和查询热门头条文章
	@RequestMapping("list.do")
	public String list(Model model,HttpSession session){
		List<Channel> list  = (List<Channel>)session.getAttribute("list");
		if(list==null){
			list  = cs.findAll();
			session.setAttribute("list", list);
		}
		
		//查询热门头条文章   
		List<Article> hots  = cs.findHot();
		model.addAttribute("articles", hots);
		return "start";
	}
	
	@RequestMapping("page.do")
	public  String page(Model model,Integer channel_id,String cpage,Integer  category_id,String like){
		PageModel pm  = new PageModel(cpage,cs.count(channel_id,category_id,like),2);
		List<Article> list = cs.findArticle(pm, channel_id, category_id,like);
		model.addAttribute("articles", list);
		model.addAttribute("pm", pm);
		model.addAttribute("channel_id",channel_id);
		model.addAttribute("category_id",category_id);
		model.addAttribute("like",like);
		//查询 channel_id栏目下的 所有的种类
		if(channel_id!=null){
			List<Category> cates = cs.findCate(channel_id);
			model.addAttribute("cates", cates);
		}
		return "start";
	}
	
	@RequestMapping("publish.do")
	public   String  publish(Model model){
		List<Channel> list   = cs.findAll();
		model.addAttribute("list", list);
		return "publishArticle";
	}
	
	@RequestMapping("findCate.do")
	@ResponseBody
	public  List<Category> findCate(int channel_id){
		List<Category> cates = cs.findCate(channel_id);
		return  cates;
	}
	
	
	@RequestMapping("upload.do")
	public     String  upload(MultipartFile  pic,Article a,HttpSession session) throws IllegalStateException, IOException{
		ServletContext application = session.getServletContext();
		//返回的  img目录  实际 部署到  服务器上 的  路径  
		//  D:\apache-tomcat-8.0.52\webapps\cms_1612\img
		String realPath = application.getRealPath("img");//根据 开发逻辑路径  获取 实际 发布到  服务器上的物理路径 
		//获取 上传文件的 文件名   
		String filename = pic.getOriginalFilename();
		//上传文件的路径 
//		String uploadPath = "D:\\image\\"+filename;
		String uploadPath = realPath+"/"+filename;
		File f = new File(uploadPath);
		pic.transferTo(f);//上传的核心
		a.setPicture(filename);
		a.setStatus(0);//0： 审核中状态      审核通过:1      审核不通过:2
		a.setHits(1000);// 点击量 
		User user = (User)session.getAttribute("login_user");
		a.setUser_id(user.getId());
		a.setCreated(new Timestamp(System.currentTimeMillis()));
		cs.save(a);
		return "forward:my.do";
	}
	
	@RequestMapping("delete.do")
	public   String   delete(int id,Model model){
		cs.deleteById(id);
		return "forward:my.do";
	}
}
