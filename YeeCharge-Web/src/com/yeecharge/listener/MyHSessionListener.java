package com.yeecharge.listener;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.yeecharge.domain.Product;

public class MyHSessionListener implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent se) {
		//当用户访问时，一创建session就将cartmap（商品列表）存入session中，
			//每个访问者只有一个session,也只有1个cartmap（购物车）
		se.getSession().setAttribute("cartmap", new LinkedHashMap<Product, Integer>());
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		
	}

}
