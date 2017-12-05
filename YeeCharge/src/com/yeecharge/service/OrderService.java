package com.yeecharge.service;

import java.util.List;

import com.yeecharge.domain.Order;
import com.yeecharge.domain.OrderListForm;
import com.yeecharge.domain.SaleInfo;
import com.yeecharge.annotation.Tran;

public interface OrderService extends Service{
	
	/**
	 * 增加订单
	 * @param order 
	 */
	@Tran
	void addOrder(Order order);
	
	/**
	 * 根据用户id查找所有订单
	 * @param id
	 * @return 查找到的数据
	 */
	List<OrderListForm> findOrders(int user_id);
	
	/**
	 * 根据订单id删除订单
	 * @param id
	 */
	@Tran
	void delOrderById(String id);
	
	/**
	 * 根据订单id查找order
	 * @param p2_Order
	 * @return
	 */
	Order findOrderById(String order_id);
	
	/**
	 * 根据订单id修改对应订单的支付状态
	 * @param r6_Order
	 * @param i
	 */
	void changePayState(String r6_Order, int i);
	
	/**
	 * 查询销售榜单
	 */
	List<SaleInfo> getSaleList();

}

