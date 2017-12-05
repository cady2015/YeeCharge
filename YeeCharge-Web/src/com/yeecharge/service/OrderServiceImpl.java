package com.yeecharge.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.yeecharge.dao.OrderDao;
import com.yeecharge.dao.ProdDao;
import com.yeecharge.dao.UserDao;
import com.yeecharge.domain.Order;
import com.yeecharge.domain.OrderItem;
import com.yeecharge.domain.OrderListForm;
import com.yeecharge.domain.Product;
import com.yeecharge.domain.SaleInfo;
import com.yeecharge.domain.User;
import com.yeecharge.factory.BasicFactory;

public class OrderServiceImpl implements OrderService {
	OrderDao orderDao = BasicFactory.getFactory().getDao(OrderDao.class);
	ProdDao prodDao = BasicFactory.getFactory().getDao(ProdDao.class);
	UserDao userDao = BasicFactory.getFactory().getDao(UserDao.class);
	
	public void addOrder(Order order) {
		try {
			//1.生成订单
			orderDao.addOrder(order);
			//2.生成订单项 3.扣除商品数量
			for(OrderItem item : order.getList()){
				orderDao.addOrderItem(item);
				prodDao.delPnum(item.getProduct_id(),item.getBuynum());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<OrderListForm> findOrders(int user_id) {
		try {
			List<OrderListForm> olflist = new ArrayList<OrderListForm>();
			//1.根据用户id查询这个id用户的所有订单
			List<Order> list = orderDao.findOrderByUserId(user_id);
			//2.遍历orders表 生成 orderListForm 
				//对象（每一个orderListForm代表每一条订单记录的所有信息），存入list对象
			for(Order order : list){
				//--设置订单信息
				OrderListForm olf = new OrderListForm();
				BeanUtils.copyProperties(olf, order);
				//--设置用户名
				User user = userDao.findUserById(order.getUser_id());
				olf.setUsername(user.getUsername());
				//--设置商品信息（通过订单id查找出所有的订单项）
				List<OrderItem> itemlist = orderDao.findOrderItems(order.getId());
				Map<Product,Integer> prodMap= new HashMap<Product,Integer>();
				for(OrderItem item :itemlist){
					String prodId = item.getProduct_id();
					Product prod = prodDao.findProdById(prodId);
					prodMap.put(prod,item.getBuynum());
				}
				olf.setProdMap(prodMap);

				olflist.add(olf);
			}
			return olflist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void delOrderById(String id) {
		//1.根据订单id查询出所有订单项
		List<OrderItem> list = orderDao.findOrderItems(id);
		//2.遍历订单项，将对应prod_id的商品库存加回去
		for(OrderItem item :list){
			prodDao.addPnum(item.getProduct_id(),item.getBuynum());
		}
		
		//3.删除订单项(先删除有外键关联的子表)
		orderDao.delItemById(id);
		//4.删除订单(后删除主表)
		orderDao.delOrderById(id);
	}

	public Order findOrderById(String order_id) {
		return orderDao.findOrderById(order_id);
	}

	
	public void changePayState(String Order_id, int i) {
		orderDao.changePayState(Order_id,i);
	}

	
	public List<SaleInfo> getSaleList() {
		return orderDao.getSaleList();
	}

}
