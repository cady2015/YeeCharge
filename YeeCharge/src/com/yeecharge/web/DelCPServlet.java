package com.yeecharge.web;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeecharge.factory.BasicFactory;
import com.yeecharge.service.CPService;
import com.yeecharge.service.UserService;

public class DelCPServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CPService service = BasicFactory.getFactory().getService(CPService.class);
		
		String id = request.getParameter("id");
		int id1 = new Integer(id);
		if(service.delCP(id1) == true ){
			response.getWriter().write("删除成功！");
		}else{
			response.getWriter().write("删除失败。。。");
		}
		response.setHeader("Refresh", "1;url=/ListCPServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
