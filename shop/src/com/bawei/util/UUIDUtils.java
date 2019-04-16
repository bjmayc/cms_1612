package com.bawei.util;

import java.security.MessageDigest;
import java.util.UUID;

import sun.misc.BASE64Encoder;

public class UUIDUtils {
	
	//返回一个32位长的UUID，一般做为主键使用
	public static String generateID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	//返回一个64位长的激活码
	public static String generateCode(){
		return UUIDUtils.generateID() + UUIDUtils.generateID();
	}

	//对密码进行MD5加密
	public static String md5(String str){
		//加密后的字符串
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
