package com.yeecharge.service;

import java.util.ArrayList;
import java.util.List;

import com.yeecharge.annotation.Tran;
import com.yeecharge.domain.CPinfo;
import com.yeecharge.domain.CPsStatus;

public interface CPService extends Service {
	/**
	 * 列出所有的充电桩安装信息
	 * @return
	 */
	List<CPinfo> listCP();

	/**
	 * 根据充电桩id删除对应的充电桩
	 * @return
	 */
	@Tran
	boolean delCP(int id);
	
	/**
	 * 部署一个充电桩
	 */
	@Tran
	int AddCP(CPinfo cp);
	
	
	/**
	 * 获取当前所有充电桩的状态信息
	 * @return
	 */
	List<CPsStatus> getCurrentCpStatus();

	/**
	 * 实现	在线充电桩个数（count_online_Cps）
			故障充电桩个数（count_fault_Cps）
			使用(正常放电)中充电桩个数（count_inuse_Cps）
			空闲充电桩个数（count_free_Cps）
		这4类数据的统计
	 * @return
	 */
	String[] countCPStatus();
	


}
