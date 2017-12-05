package com.yeecharge.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.yeecharge.domain.CPinfo;
import com.yeecharge.domain.CPsStatus;
import com.yeecharge.util.TransactionManager;

public class CPDaoImpl implements CPDao {

	public List<CPinfo> getAllCP() {
		String sql = "select * from cp_info";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<CPinfo>(CPinfo.class));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public boolean delCP(int id) {
		String sql = "delete from cp_info where cp_id = ?";
		try {
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			int count = runner.update(sql, id);
			if(count>=1){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public int addCP(CPinfo cp) {
		
		String sql = "insert into cp_info values( ?,?,?,?,?,?)";
		
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.update(sql, null ,cp.getCp_num(),cp.getCp_model(),cp.getLatitude(),cp.getLongitude(),cp.getInstall_time()) ;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	public List<CPsStatus> getCurrentCpStatus() {
		String sql = "select cp_id,cp_voltage,cp_current,cp_temperature,cp_status,energy_left,update_time from status_count";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<CPsStatus>(CPsStatus.class));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public String countCpStatus(int i) {
		String[] sql ={ 
				//		统计在线充电桩总个数：
				"select count(*) from status_count"
				//		统计故障充电桩个数：cp_status=0 or cp_status=8
				,"select count(cp_status) from status_count where cp_status=0 or cp_status=8"
				//		统计正在使用中的充电桩个数:  cp_status=2
				,"select count(cp_status) from status_count where cp_status=2"
				//		统计空闲充电桩个数：cp_status=4
				,"select count(cp_status) from status_count where cp_status=4"

		};
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			Object[] result = runner.query(sql[i],new ArrayHandler());
			   	String r = result[0].toString();
//				System.out.println(r);
			return r;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
