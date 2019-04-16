package com.bawei.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class CheckcodeServlet extends HttpServlet {
	private static final long serialVersionUID = -8910878736136188428L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String str=request.getParameter("state");
		response.setContentType("image/jpeg");
		
		// 图片的内存映像
		BufferedImage image = 
			new BufferedImage(120, 36,
				BufferedImage.TYPE_INT_RGB);
		// 获得画笔对象
		Random r = new Random();
		Graphics g = image.getGraphics();
		//上颜色（背景颜色）
		g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		g.fillRect(0, 0, 120, 36);
		g.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,25));
		g.setColor(new Color(0,0,0));
		String number = String.valueOf(r.nextInt(9000)+1000); 
		
//		HttpSession session=request.getSession();
//		
//		System.out.println("注册验证码:"+number);
//		session.setAttribute("register_code", number);
//		
		g.drawString(number, 30, 25);
		//加一些干扰线
		g.drawLine(r.nextInt(120), r.nextInt(36), 
				r.nextInt(120), r.nextInt(36));
		g.drawLine(r.nextInt(120), r.nextInt(36), 
				r.nextInt(120), r.nextInt(36));
		g.drawLine(r.nextInt(120), r.nextInt(36), 
				r.nextInt(120), r.nextInt(36));
		g.drawLine(r.nextInt(120), r.nextInt(36), 
				r.nextInt(120), r.nextInt(36));
		// 压缩成jpeg格式
		OutputStream os = response.getOutputStream();
		
		JPEGImageEncoder encoder = 
			JPEGCodec.createJPEGEncoder(os);

		// 把BufferedImage对象中的图像信息编码后
		// 向创建该对象(encoder)时指定的输出流输出
		encoder.encode(image);
	}
}
