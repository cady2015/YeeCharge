package com.yeecharge.dao;

import java.sql.SQLException;
import java.util.List;

import com.yeecharge.domain.Product;


public interface ProdDao extends Dao {
	/**
	 * 调用数据库添加商品的方法
	 * @param prod
	 */
	void addProd(Product prod);
	
	/**
	 * 列出所有商品
	 * @return
	 */
	List<Product> findAllProd();
	
	/**
	 * 根据商品id查找商品
	 * @param id
	 * @return	返回该商品bean
	 */
	Product findProdById(String id);
	
	/**
	 * 扣除相应商品的数量
	 * @param product_id
	 * @param buynum
	 * @throws SQLException 
	 */
	void delPnum(String product_id, int buynum) throws SQLException;
	
	/**
	 * 加上商品的数量
	 * @param product_id
	 * @param buynum
	 */
	void addPnum(String product_id, int buynum);

}
