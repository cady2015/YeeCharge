package com.yeecharge.web;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeecharge.domain.User;
import com.yeecharge.factory.BasicFactory;
import com.yeecharge.service.UserService;

public class ListUserServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service = BasicFactory.getFactory().getService(UserService.class);
		String id = (String) request.getAttribute("id");
		//---------无参数请求--------
		if((id=="") ||(id==null)){
			//从数据库中查找出所有的用户 组成一张list返回
			List<User> list = service.getUsersList();
			request.setAttribute("usersList", list);
			//请求转发到listUser.jsp
			request.getRequestDispatcher("/userslist.jsp").forward(request, response);
		//---------有参数请求,说明是修改用户信息的请求--------
		}else{
			//从数据库中查找出对应id的用户 
			User user= service.getUser(id);
			request.setAttribute("userInfo", user);
			//请求转发到alterUser.jsp
			request.getRequestDispatcher("/alterUser.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
