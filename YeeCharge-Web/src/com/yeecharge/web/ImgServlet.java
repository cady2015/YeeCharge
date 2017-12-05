package com.yeecharge.web;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeecharge.domain.Product;
import com.yeecharge.factory.BasicFactory;
import com.yeecharge.service.ProdService;

public class ImgServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. 根据id查找出商品
		ProdService service = BasicFactory.getFactory().getService(ProdService.class);
		Product prod = service.findProdById(request.getParameter("id"));
		//2.获取商品url，输出图片
		String imgurl = request.getParameter("imgurl");
		request.getRequestDispatcher(imgurl).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
