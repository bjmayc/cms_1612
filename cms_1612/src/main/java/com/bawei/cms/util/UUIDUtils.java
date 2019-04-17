package com.bawei.cms.util;

import java.security.MessageDigest;
import java.util.UUID;

import sun.misc.BASE64Encoder;
/**
 * 
 * 工具类
 * @author myc
 *@time 2019年3月21日
 *
 *
 */
public class UUIDUtils {
	
	public static String generateID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public static String generateCode(){
		return UUIDUtils.generateID() + UUIDUtils.generateID();
	}

	public static String md5(String str){
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
	
	public static void main(String[] args) {
		String newPwd = md5("111111");
		System.out.println(newPwd);
	}

}
