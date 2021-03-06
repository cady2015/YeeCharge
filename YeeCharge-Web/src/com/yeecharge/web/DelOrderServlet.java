package com.yeecharge.web;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeecharge.factory.BasicFactory;
import com.yeecharge.service.OrderService;

public class DelOrderServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderService service = BasicFactory.getFactory().getService(OrderService.class);
		//1.获取订单id 
		String id = request.getParameter("id");
		//2.调用service中根据订单id删除订单的方法
		service.delOrderById(id);
		//3.删除后再重新回到订单列表页面
		response.getWriter().write("订单删除成功！");
		response.setHeader("refresh", "3;url=/OrderListServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
