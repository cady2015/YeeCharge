package com.yeecharge.web;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeecharge.domain.OrderListForm;
import com.yeecharge.domain.User;
import com.yeecharge.factory.BasicFactory;
import com.yeecharge.service.OrderService;

public class OrderListServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderService service = BasicFactory.getFactory().getService(OrderService.class);
		//1.获取用户id
		User user = (User) request.getSession().getAttribute("user");
		int user_id = user.getId();
		//2.在service中根据id查询用户所有的订单的方法
		List<OrderListForm> list = service.findOrders(user_id);
		//3.将查询结果存入request域中带到页面显示
		request.setAttribute("list", list);
		request.getRequestDispatcher("/orderList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
