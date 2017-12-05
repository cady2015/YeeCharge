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
		//1.��ȡ�û�id
		User user = (User) request.getSession().getAttribute("user");
		int user_id = user.getId();
		//2.��service�и���id��ѯ�û����еĶ����ķ���
		List<OrderListForm> list = service.findOrders(user_id);
		//3.����ѯ�������request���д���ҳ����ʾ
		request.setAttribute("list", list);
		request.getRequestDispatcher("/orderList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
