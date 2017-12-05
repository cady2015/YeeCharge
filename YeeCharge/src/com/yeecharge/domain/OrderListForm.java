package com.yeecharge.domain;

import java.sql.Timestamp;
import java.util.Map;

public class OrderListForm {
	private String id;
	private double money;
	private String receiverinfo;
	private int paystate;
	private Timestamp ordertime;
	private String username;//--用户表中的信息  --用户名
	private Map<Product,Integer> prodMap;//订单项信息--商品表中的信息   商品--数量
//--------------------------------------------
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getReceiverinfo() {
		return receiverinfo;
	}
	public void setReceiverinfo(String receiverinfo) {
		this.receiverinfo = receiverinfo;
	}
	public int getPaystate() {
		return paystate;
	}
	public void setPaystate(int paystate) {
		this.paystate = paystate;
	}
	public Timestamp getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Timestamp ordertime) {
		this.ordertime = ordertime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Map<Product,Integer> getProdMap() {
		return prodMap;
	}
	public void setProdMap(Map<Product,Integer> prodMap) {
		this.prodMap = prodMap;
	}

}
