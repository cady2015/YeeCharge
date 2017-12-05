package com.yeecharge.filter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeecharge.domain.User;

public class PrivilegeFilter implements Filter {
	private List<String> adminList = new ArrayList<String>();
	private List<String> userList = new ArrayList<String>();
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//1.当前来访者的路径
		String uri = req.getRequestURI();
		
		if(adminList.contains(uri) || userList.contains(uri)){
			//说明当前资源需要权限（没有在列表中的说明不需要权限就能访问）
			if(req.getSession(false)==null || req.getSession().getAttribute("user")==null){
				response.getWriter().write("当前资源需要权限，请先登录！");
				return;
			}
			User user = (User) req.getSession().getAttribute("user");
			if(adminList.contains(uri) &&"admin".equals(user.getRole())){
				//说明当前访问的是admin权限资源并且是admin用户
				chain.doFilter(request, response);
			}else if(userList.contains(uri) &&"user".equals(user.getRole())){
				//说明当前访问的是user权限资源并且是user用户
				chain.doFilter(request, response);
			}else {
				throw new RuntimeException("您不具有对应的权限！");
			}
			
		}else{//不需要权限
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		ServletContext context = arg0.getServletContext();
		try {
			BufferedReader adminReader = new BufferedReader(new FileReader(context.getRealPath("WEB-INF/admin.txt")));
			String line = null;
			while((line=adminReader.readLine()) != null){
				adminList.add(line);
			}
			
			BufferedReader userReader = new BufferedReader(new FileReader(context.getRealPath("WEB-INF/user.txt")));
			line = null;
			while((line=userReader.readLine()) != null){
				userList.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
