package com.yeecharge.web;


import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeecharge.domain.Product;
import com.yeecharge.factory.BasicFactory;
import com.yeecharge.service.ProdService;

public class DelCartServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProdService service = BasicFactory.getFactory().getService(ProdService.class);
		//1.获取要删除的id，根据id查找商品
		String id = request.getParameter("id");
		Product prod = service.findProdById(id);
		//2.找到购物车，删掉该商品
		Map<Product, Integer> cartmap = (Map<Product, Integer>) request.getSession().getAttribute("cartmap");
		cartmap.remove(prod);
		//3.重定向到购物车页面
		response.sendRedirect("/cart.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
