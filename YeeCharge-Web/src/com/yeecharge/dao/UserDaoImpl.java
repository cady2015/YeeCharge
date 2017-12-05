package com.yeecharge.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.yeecharge.domain.CPinfo;
import com.yeecharge.domain.User;
import com.yeecharge.util.TransactionManager;

public class UserDaoImpl implements UserDao {

	public User findUserByName(String username) {
		String sql = "select * from users where username = ?";
		try {
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<User>(User.class), username);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	public void addUser(User user) {
		String sql = "insert into users values(null,?,?,?,?,?,?,?,null)";
			try {
				QueryRunner runner = new QueryRunner(TransactionManager.getSource());
				runner.update(sql, user.getUsername(),user.getPassword(),user.getPhonenum(),user.getEmail(),user.getRole(),user.getState(),user.getActivecode());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		
	}
	
	public void delUser(int id) {
		String sql = "delete from users where id = ?";
		try {
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void updateState(int id, int newState) {
		String sql = "update users set state = ? where id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql, newState, id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public User findUserByActivecode(String activecode) {
		String sql = "select * from users where activecode = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<User>(User.class),activecode);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public User finUserByNameAndPsw(String username, String password) {
		String sql = "select * from users where username = ? and password = ?"; 
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<User>(User.class), username, password);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public User findUserById(int id) {
		String sql = "select * from users where id = ?"; 
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<User>(User.class), id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<User> getAllUsers() {
		String sql = "select * from users";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<User>(User.class));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}



}


	
	



