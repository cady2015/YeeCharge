package com.yeecharge.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeecharge.domain.User;
import com.yeecharge.factory.BasicFactory;
import com.yeecharge.service.UserService;

public class AutologinFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//1.只有未登录的才进行自动登录
		if(req.getSession(false)==null || req.getSession().getAttribute("user")==null){
			//2.只有带自动登录cookie的用户才自动登录
			Cookie cs [] = req.getCookies();
			Cookie findC = null;
			if(cs!=null){
				for(Cookie c: cs){
					if("autologin".equals(c.getName())){
						findC = c;
						break;
					}
				}
			}
			if(findC!=null){
				//3.只有cookie中的用户名和密码都正确才自动登录
				String v = URLDecoder.decode(findC.getValue(),"utf-8");
				String username = v.split(":")[0];
				String password = v.split(":")[1];
				UserService service = BasicFactory.getFactory().getService(UserService.class);
				User user = service.getUserByNameAndPsw(username, password);
				if(user!=null){
					req.getSession().setAttribute("user", user);
				}
			}
		
		}
		//4.无论是否勾选自动登录都放行
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
