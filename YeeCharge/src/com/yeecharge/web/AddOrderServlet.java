package com.yeecharge.web;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.yeecharge.domain.Order;
import com.yeecharge.domain.OrderItem;
import com.yeecharge.domain.Product;
import com.yeecharge.domain.User;
import com.yeecharge.factory.BasicFactory;
import com.yeecharge.service.OrderService;

public class AddOrderServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderService service = BasicFactory.getFactory().getService(OrderService.class);
		try {
			Order order = new Order();
			//1.将订单信息存入Order bean中
				//--Id
			order.setId(UUID.randomUUID().toString());
				//--收货地址
			BeanUtils.populate(order, request.getParameterMap());
				//支付状态设置
			order.setPaystate(0);
			//--金额\订单项 存入order（订单）中（源数据--cartmap（购物车））
			Map<Product,Integer> cartmap = (Map<Product, Integer>) request.getSession().getAttribute("cartmap");
			double money = 0;
			List<OrderItem> list = new ArrayList<OrderItem>();//存放订单项信息
			for(Map.Entry<Product, Integer> entry :cartmap.entrySet()){
				money += entry.getKey().getPrice()*entry.getValue();
				
				OrderItem item = new OrderItem();
				item.setOrder_id(order.getId());
				item.setProduct_id(entry.getKey().getId());
				item.setBuynum(entry.getValue());
				list.add(item);
			}
			order.setMoney(money);
			order.setList(list);
			//获取用户id
			User user = (User) request.getSession().getAttribute("user");
			order.setUser_id(user.getId());
	//------------------Order bean和OrderItem列表已经存完---------------------------
		
			//2.调用service中的添加订单的方法
			service.addOrder(order);
			
			//3.清空购物车
			cartmap.clear();
			//4.回到主页
			response.getWriter().write("订单生成成功！请前去支付！");
			response.setHeader("refresh", "3;url=/index.jsp");
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
