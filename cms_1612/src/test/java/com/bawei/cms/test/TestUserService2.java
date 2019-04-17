package com.bawei.cms.test;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bawei.cms.domain.User;
import com.bawei.cms.service.UserService;

//Spring与  junit集成 测试 
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("classpath:applicationContext.xml")
public class TestUserService2 {
	
	@Autowired
//	@Resource  都可以
	private  UserService service;
	
	@Test
	public  void testRegist(){
		User u   = new User();
		u.setNickname("张三丰");
		u.setUsername("zhangsanfeng");
		u.setPassword("888888");
		u.setBirthday(new Date());
		u.setCreateTime(new Timestamp(0));
		u.setGender("男");
		u.setLocked(1);
		service.regist(u);
	}
	//TODO 作业:测试  别的Service方法 (UserService中的  Channel的Service方法...)
}
