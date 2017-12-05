package com.yeecharge.web;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValiImg extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//禁止缓存验证码图片
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-Cache");
		response.setHeader("pragma", "no-Cache");
		
		int height = 40;
		int width = 40*4;
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics2D g =  (Graphics2D) image.getGraphics();
		
		//1.填充矩形
		g.setColor(new Color(0xCC,0xFF,0xFF));
		g.fillRect(0, 0, width, height);
		
		//2.画边框
		g.setColor(Color.WHITE);
		g.drawRect(0, 0, width-1, height-1);
		
		//3.画干扰线
//		g.setColor(Color.RED);
//		for(int i = 0;i<5;i++){
//			g.drawLine(getRandInt(0,width), getRandInt(0,height), getRandInt(0,width), getRandInt(0,height));
//		}
		//4.随机生成字符写到图片上 
		 String base = "ABCDEFGHJKLMNOPQRSTUVWXYZ123456789";
		g.setFont(new Font("微软雅黑",Font.BOLD,20));
		g.setColor(new Color(0x00,0x33,0x66));
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<4;i++){//--一次生成4个字母
			//生成随机角度
			double c = getRandInt(-30, 30)/180F*Math.PI;
			//旋转该字母
			g.rotate(c, 5+width/4*i, 22);
			String s = base.charAt(getRandInt(0,base.length()-1))+"";
			g.drawString(s, 5+width/4*i, 22);
			g.rotate(-c, 5+width/4*i, 22);
			buffer.append(s);
		}
		System.out.println(buffer.toString());
		request.getSession().setAttribute("valistr", buffer.toString());
		//5.释放资源
		g.dispose();
		//6.利用ImageIO进行输出
		ImageIO.write(image, "jpg", response.getOutputStream());
	
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	Random random = new Random();
	//获取随机数的函数
	public int getRandInt(int begin,int end){
		return random.nextInt(end-begin)+begin;
	}

}
