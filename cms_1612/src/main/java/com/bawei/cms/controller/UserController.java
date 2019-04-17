package com.bawei.cms.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bawei.cms.domain.Article;
import com.bawei.cms.domain.User;
import com.bawei.cms.service.UserService;
import com.bawei.cms.util.UUIDUtils;

@Controller
public class UserController {
	@Autowired
	private UserService  us;
	
	@RequestMapping("regist.do")
	public   String  regist(User u){
		Timestamp created = new Timestamp(System.currentTimeMillis());
		//TODO 这里可以对密码  md5处理后 保存在数据库中
		u.setCreateTime(created);
		u.setUpdateTime(created);
		u.setLocked(1);//状态  1:可以使用    0:禁用
		us.regist(u);
		return  "login";
	}
	
	@RequestMapping("checkcode.do")
	@ResponseBody
	public   boolean  checkcode(String code,HttpSession session){
		//获取  图片上生成的 正确的 验证码
		String number = (String)session.getAttribute("number");
		//和用户输入的做比较 
		if(number.equalsIgnoreCase(code)){
			return  true;
		}else{
			return false;
		}
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session){
		session.removeAttribute("login_user");
		return "login";
	}
	
	@RequestMapping("existUsername.do")
	@ResponseBody
	public   boolean  existUsername(String username){
		boolean flag  = us.existUsername(username);
		return  flag;
	}
	
	@RequestMapping("login.do")
	public   String  login(String username,String password,Model model,HttpSession session){
		User user    = us.login(username, password);
		if(user!=null && user.getLocked()==1){
			session.setAttribute("login_user", user);
			return "forward:list.do";
		}
		if(user!=null && user.getLocked()==0){
			model.addAttribute("login_error", "账户被禁用");
			return "login";
		}
		model.addAttribute("login_error","用户名或者密码错误");
		return "login";
	}
	
	@RequestMapping("my.do")
	public   String  publish(HttpSession session,Model model){
		User user = (User)session.getAttribute("login_user");
		List<Article> list = us.findArticle(user.getId());
		model.addAttribute("list", list);
		return "articleList";
	}
	@RequestMapping("toUpdate.do")
	public  String  toUpdate(int id,Model model){
		System.out.println("id="+id);
		User u = us.findById(id);
		model.addAttribute("u", u);
		return "accountSetting";
	}
	
	@RequestMapping("update.do")
	public  String  update(User u,HttpSession session){
		us.update(u);
		User user = (User)session.getAttribute("login_user");
		user.setNickname(u.getNickname());
		session.setAttribute("login_user", user);
		return "forward:my.do";
	}
	@RequestMapping("updatePwd.do")
	public  String updatePwd(String username,String new_password){
		System.out.println("username="+username);
		us.updatePwd(username, new_password);
		return "login";
	}
	
}
