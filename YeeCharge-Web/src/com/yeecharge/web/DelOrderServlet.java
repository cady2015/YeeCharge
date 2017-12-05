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
		//1.��ȡ����id 
		String id = request.getParameter("id");
		//2.����service�и��ݶ���idɾ�������ķ���
		service.delOrderById(id);
		//3.ɾ���������»ص������б�ҳ��
		response.getWriter().write("����ɾ���ɹ���");
		response.setHeader("refresh", "3;url=/OrderListServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
