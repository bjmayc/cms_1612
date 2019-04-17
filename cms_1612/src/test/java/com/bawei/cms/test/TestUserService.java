package com.bawei.cms.test;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bawei.cms.domain.User;
import com.bawei.cms.service.UserService;
import com.mchange.util.Base64Encoder;

public class TestUserService {
	//junit 测试 
	@Test
	public void   testRegist(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService  us  = (UserService)ac.getBean("userServiceImpl");
		User u   = new User();
		u.setNickname("我是无敌");
		u.setUsername("wudi");
		u.setPassword("222222");
		u.setBirthday(new Date());
		u.setCreateTime(new Timestamp(0));
		u.setGender("男");
		u.setLocked(1);
		us.regist(u);
	}
	
	
	public static String generateRandomStr(int len) {
		String generateSource = "0123456789ABCDEFGHIGKLMNOPQRSTUVWXYZ";
			String rtnStr = "";
			for (int i = 0; i < len; i++) {
		//	       循环随机获得当次字符，并移走选出的字符
					String nowStr = String.valueOf(generateSource.charAt((int) Math.floor(Math.random() * generateSource.length())));
					rtnStr += nowStr;
					generateSource = generateSource.replaceAll(nowStr, "");
			}
		return rtnStr;
	}
	
	@Test
	public void test2(){
		String s  = generateRandomStr(6);
		System.out.println(s);
	}
	
}
