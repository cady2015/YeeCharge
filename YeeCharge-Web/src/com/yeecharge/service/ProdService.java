package com.yeecharge.service;

import java.util.List;

import com.yeecharge.domain.Product;

public interface ProdService extends Service {
	
	/**
	 * 添加商品信息
	 * @param prod ：商品信息bean
	 */
	void addProd(Product prod);
	/**
	 * 查询所有商品
	 * @return 商品信息列表
	 */
	List<Product> findAllProd();
	
	/**
	 * 根据id查找商品
	 * @param id
	 * @return
	 */
	Product findProdById(String id);

}
