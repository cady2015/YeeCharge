package com.yeecharge.service;

import java.util.List;
import java.util.UUID;

import com.yeecharge.dao.ProdDao;
import com.yeecharge.domain.Product;
import com.yeecharge.factory.BasicFactory;

public class ProdServiceImpl implements ProdService {
	ProdDao dao = BasicFactory.getFactory().getDao(ProdDao.class);

	public void addProd(Product prod) {
		//数据库中主键是string类型的，为了保证主键不重复，使用UUID编码来命名主键
		prod.setId(UUID.randomUUID().toString());
		dao.addProd(prod); 
	}

	public List<Product> findAllProd() {
		
		return dao.findAllProd();
	}

	public Product findProdById(String id) {
		return dao.findProdById(id);
	}

}
