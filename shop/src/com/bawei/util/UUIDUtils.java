package com.bawei.util;

import java.security.MessageDigest;
import java.util.UUID;

import sun.misc.BASE64Encoder;

public class UUIDUtils {
	
	//����һ��32λ����UUID��һ����Ϊ����ʹ��
	public static String generateID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	//����һ��64λ���ļ�����
	public static String generateCode(){
		return UUIDUtils.generateID() + UUIDUtils.generateID();
	}

	//���������MD5����
	public static String md5(String str){
		//���ܺ���ַ���
		String newstr = null;
		try {
			MessageDigest md5=MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
		} catch (Exception e) {
			e.printStackTrace();
		}
        return newstr;
	}

}
