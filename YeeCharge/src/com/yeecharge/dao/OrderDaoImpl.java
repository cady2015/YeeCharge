package com.yeecharge.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.yeecharge.domain.Order;
import com.yeecharge.domain.OrderItem;
import com.yeecharge.domain.SaleInfo;
import com.yeecharge.util.TransactionManager;

public class OrderDaoImpl implements OrderDao {

	public void addOrder(Order order) throws SQLException {
		String sql = "insert into orders values (?,?,?,?,null,?)";
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,order.getId(),order.getMoney(),order.getReceiverinfo(),order.getPaystate(),order.getUser_id());
	}


	public List<Order> findOrderByUserId(int user_id) {
		String sql = "select * from orders where user_id = ?";
		try {
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Order>(Order.class),user_id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void delOrderById(String id) {
		String sql = "delete from orders where id = ?";
		try {
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public Order findOrderById(String order_id) {
		String sql = "select * from orders where id = ?";
		try {
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<Order>(Order.class),order_id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	public void changePayState(String order_id, int i) {
		String sql = "update orders set paystate = ? where id = ?";
		try {
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,i,order_id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	public List<SaleInfo> getSaleList() {
		String sql = 
		" SELECT orderitem.product_id prod_id,products.`name` prod_name,SUM(buynum) sale_num"+
		" FROM orderitem , orders ,products  "+
		" WHERE orderitem.`order_id`=orders.`id` "+
		" AND orderitem.`product_id`=products.`id`"+
		" AND orders.`paystate`=1 "+
		" GROUP BY prod_id "+
		" ORDER BY sale_num DESC";
		try {
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<SaleInfo>(SaleInfo.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

//--------------------------------------------------------------------------------
	public List<OrderItem> findOrderItems(String id) {
		String sql = "select * from orderitem where order_id = ?";
		try {
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<OrderItem>(OrderItem.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public void addOrderItem(OrderItem item) throws SQLException {
		String sql = "insert into orderitem values (?,?,?)";
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,item.getOrder_id(),item.getProduct_id(),item.getBuynum());
	}

	
	public void delItemById(String id) {
		String sql = "delete from orderitem where order_id = ?";
		try {
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}





}
