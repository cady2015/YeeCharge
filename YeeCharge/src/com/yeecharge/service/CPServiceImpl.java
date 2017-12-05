package com.yeecharge.service;

import java.util.List;

import com.yeecharge.dao.CPDao;
import com.yeecharge.domain.CPinfo;
import com.yeecharge.domain.CPsStatus;
import com.yeecharge.factory.BasicFactory;

public class CPServiceImpl implements CPService{
	
	private CPDao dao  = BasicFactory.getFactory().getDao(CPDao.class);
	
	public List<CPinfo> listCP() {
		List<CPinfo> list = dao.getAllCP();
		return list;
	}

	public boolean delCP(int id) {
		boolean result =  dao.delCP(id);
		return result;
	}

	public int AddCP(CPinfo cp) {
		int result = dao.addCP(cp);
		return result;
	}

	public List<CPsStatus> getCurrentCpStatus() {
		return dao.getCurrentCpStatus();
	}

	public String[] countCPStatus() {
		//表示有4组数据需要查询
		int number_of_params = 4;
		
		String[] results = new String[4];
		
		for(int num=0; num < number_of_params; num++)
		{
			results[num] = dao.countCpStatus(num);
		}
		return results;
	}
	
}
