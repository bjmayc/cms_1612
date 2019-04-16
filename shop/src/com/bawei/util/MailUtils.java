package com.bawei.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailUtils {

	//第一个参数：收件人邮箱地址，第二个参数：激活码
	public static void sendMail(String address , String code){
		// Session对象:
		Properties props = new Properties();
		// props.setProperty("smtp.host", "localhost");
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("admin@baway.com", "123");
			}
			
		});
		// Message对象:
		Message message = new MimeMessage(session);
		// 设置发件人：
		try {
			message.setFrom(new InternetAddress("admin@baway.com"));
			// 设置收件人:
			message.addRecipient(RecipientType.TO, new InternetAddress(address));
			// 设置主题:
			message.setSubject("来自八维商城的激活邮件");
			// 设置内容：
			message.setContent("<h1>来自八维商城的激活邮件！激活请点击以下链接！</h1><h3><a href='http://localhost:8080/shop/active.do?code="+code+"'>http://localhost:8080/shop/active?code="+code+"</a></h3>","text/html;charset=UTF-8");
			// Transport对象:
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		sendMail("mayangcheng_121@163.com","这是用JavaMail发送的测试邮件0000001");
	}
}
