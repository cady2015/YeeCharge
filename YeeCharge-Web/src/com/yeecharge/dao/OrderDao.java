package com.yeecharge.dao;

import java.sql.SQLException;
import java.util.List;

import com.yeecharge.domain.Order;
import com.yeecharge.domain.OrderItem;
import com.yeecharge.domain.SaleInfo;



public interface OrderDao extends Dao{
	
	/**
	 * 在订单表中插入记录
	 * @param order
	 * @throws SQLException 
	 */
	void addOrder(Order order) throws SQLException;
	

	/**
	 * 根据用户id在orders表中查找出所有的订单
	 * @param user_id
	 * @return
	 */
	List<Order> findOrderByUserId(int user_id);
	
	/**
	 * 通过订单id删除订单记录
	 * @param id
	 */
	void delOrderById(String id);
	
	/**
	 * 根据订单id查找订单信息
	 * @param order_id
	 * @return
	 */
	Order findOrderById(String order_id);
	
	/**
	 * 根据订单id改变订单的支付状态
	 * @param order_id
	 * @param i
	 */
	void changePayState(String order_id, int i);

//-----------------------------------------------------------------------------
	/**
	 * 根据订单order_id在orderitem表中查找出所有的订单项orderItem
	 * @param id
	 * @return
	 */
	List<OrderItem> findOrderItems(String id);
	
	/**
	 * 根据订单id删除所有关联的orderItem订单项记录
	 * @param id
	 */
	void delItemById(String id);
	

	/**
	 * 在订单项表中插入记录
	 * @param item
	 * @throws SQLException 
	 */
	void addOrderItem(OrderItem item) throws SQLException;
	
	/**
	 * 查询销售榜单（多表联查）
	 * @return
	 */
	List<SaleInfo> getSaleList();





}
