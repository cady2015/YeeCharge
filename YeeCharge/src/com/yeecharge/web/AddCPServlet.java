package com.yeecharge.web;


import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.yeecharge.domain.CPinfo;
import com.yeecharge.factory.BasicFactory;
import com.yeecharge.service.CPService;
import com.yeecharge.util.TimeFormatter;

public class AddCPServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CPService service = BasicFactory.getFactory().getService(CPService.class);
		//从请求表单中获取参数
		String cp_num = request.getParameter("cp_num");
		String cp_model = request.getParameter("cp_model");
		String longitude = request.getParameter("longitude");
		String latitude = request.getParameter("latitude");
		String install_time = request.getParameter("install_time");
		System.out.println(install_time +"正在存储充电桩部署数据。。。");
		
		CPinfo cp = new CPinfo();
		
		cp.setCp_num(Integer.parseInt(cp_num));
		cp.setCp_model(cp_model);
		cp.setLongitude(longitude);
		cp.setLatitude(latitude);
		
		
		try {
			cp.setInstall_time(TimeFormatter.formatTime(install_time));
		} catch (Exception e) {
			e.printStackTrace();
		}

		int addResult = service.AddCP(cp);
		
		response.getWriter().write("成功部署"+addResult+"个充电桩");
		
		response.setHeader("refresh", "1;url=/ListCPServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
