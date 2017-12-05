package com.yeecharge.web;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeecharge.domain.Product;
import com.yeecharge.factory.BasicFactory;
import com.yeecharge.service.ProdService;

public class ProdListServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProdService service = BasicFactory.getFactory().getService(ProdService.class);
		//1.调用service查询所有商品
		List<Product> list = service.findAllProd();
		//2.将所有的商品信息存入request域后带到页面中进行展示
		request.setAttribute("list", list);
		request.getRequestDispatcher("/prodList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
