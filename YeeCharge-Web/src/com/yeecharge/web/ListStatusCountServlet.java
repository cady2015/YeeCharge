package com.yeecharge.web;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeecharge.domain.CPsStatus;
import com.yeecharge.factory.BasicFactory;
import com.yeecharge.service.CPService;

public class ListStatusCountServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CPService service = BasicFactory.getFactory().getService(CPService.class);
		//定义用于返回的数据
		String json ="";
		//1.从数据库中获取充电桩统计信息
		String[] CountResults = service.countCPStatus();
		
		//2.将统计信息转换成json格式
		//"json = {rst1:10,rst2:1,rst3:4,rst4:5}"
		
		for(int r=0;r<CountResults.length;r++){
			if(r==0){
				json += "{rst"+r+":"+CountResults[r]+",";
			}else if(r==CountResults.length-1){
				json += "rst"+r+":"+CountResults[r]+"}";
			}else{
				json += "rst"+r+":"+CountResults[r]+",";
			}
		}
		
		//3.json形式的数据返回给ajax调用端 showmap.jsp
		response.getWriter().write(json);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
