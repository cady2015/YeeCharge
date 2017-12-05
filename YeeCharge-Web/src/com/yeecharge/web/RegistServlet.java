package com.yeecharge.web;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.yeecharge.domain.User;
import com.yeecharge.factory.BasicFactory;
import com.yeecharge.service.UserService;
import com.yeecharge.util.MD5Utils;

public class RegistServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service  = BasicFactory.getFactory().getService(UserService.class);
		try {
			//1.校验验证码
			String valistr1 = request.getParameter("valistr").toUpperCase();
			String valistr2 = (String) request.getSession().getAttribute("valistr");
							//注意！！String类型数据 互相比较时一定要用.equals()方法！！
			if(valistr1==null || valistr2==null || !valistr1.equals(valistr2)){
				request.setAttribute("msg", "验证码不正确！");
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}
			//2.封装数据 校验数据
			User user = new User();
			BeanUtils.populate(user,request.getParameterMap());
			user.setPassword(MD5Utils.md5(user.getPassword()));
			//3.调用service注册用户
			service.regist(user);
			//4.回到主页
			response.getWriter().write("注册成功！请到邮箱中进行激活...");
				//本应该是跳转向邮箱的页面
			response.setHeader("Refresh", "3;url=/index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
