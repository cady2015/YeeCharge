package com.yeecharge.dao;

import java.util.List;

import com.yeecharge.domain.CPinfo;
import com.yeecharge.domain.CPsStatus;

public interface CPDao extends Dao{
	/**
	 * 获取所有的充电桩安装信息
	 * @return
	 */
	List<CPinfo> getAllCP();
	
	/**
	 * 根据充电桩id删除对应的充电桩
	 * @param id
	 * @return
	 */
	boolean delCP(int id);

	/**
	 * 向CP_info表中插入一条记录
	 * @param cp
	 * @return
	 */
	int addCP(CPinfo cp);

	/**
	 * 查询 StatusCount表中的所有字段（除过id字段）
	 * @return
	 */
	List<CPsStatus> getCurrentCpStatus();

	/**
	 * 使用sql多次请求实现充电桩个数的统计
	 * 
	 * @return
	 */
	String countCpStatus(int i);
}
