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

	//��һ���������ռ��������ַ���ڶ���������������
	public static void sendMail(String address , String code){
		// Session����:
		Properties props = new Properties();
		// props.setProperty("smtp.host", "localhost");
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("admin@baway.com", "123");
			}
			
		});
		// Message����:
		Message message = new MimeMessage(session);
		// ���÷����ˣ�
		try {
			message.setFrom(new InternetAddress("admin@baway.com"));
			// �����ռ���:
			message.addRecipient(RecipientType.TO, new InternetAddress(address));
			// ��������:
			message.setSubject("���԰�ά�̳ǵļ����ʼ�");
			// �������ݣ�
			message.setContent("<h1>���԰�ά�̳ǵļ����ʼ������������������ӣ�</h1><h3><a href='http://localhost:8080/shop/active.do?code="+code+"'>http://localhost:8080/shop/active?code="+code+"</a></h3>","text/html;charset=UTF-8");
			// Transport����:
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		sendMail("mayangcheng_121@163.com","������JavaMail���͵Ĳ����ʼ�0000001");
	}
}
