package com.yeecharge.web;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeecharge.domain.CPinfo;
import com.yeecharge.factory.BasicFactory;
import com.yeecharge.service.CPService;
import com.yeecharge.service.UserService;

public class ListCPServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CPService service = BasicFactory.getFactory().getService(CPService.class);
		
		List<CPinfo> list = service.listCP();
		request.setAttribute("CPlist", list);
		
		request.getRequestDispatcher("listCP.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
