package com.yeecharge.dao;

import java.util.List;

import com.yeecharge.domain.CPinfo;
import com.yeecharge.domain.User;

public interface UserDao extends Dao {
	
	/**
	 * 根据用户名查找用户是否存在，如果找到则返回user
	 * @param username
	 * @return
	 */
	User findUserByName(String username);
	/**
	 * 通过数据库添加用户
	 * @param user
	 */
	void addUser(User user);
	
	
	/**
	 * 删除用户
	 */
	void delUser(int id);
	/**
	 * 更新用户激活状态
	 * @param id  用户id
	 * @param newState		要设置的user新激活状态，通常为1
	 */
	void updateState(int id, int newState);
	
	/**
	 * 根据验证码查找匹配用户
	 * @param activecode 激活码
	 * @return 如果找到则返回User  如果找不到则返回null
	 */
	User findUserByActivecode(String activecode);
	
	/**
	 * 根据用户名和密码查找用户
	 * @param username
	 * @param password
	 * @return  如果找到则返回User  如果找不到则返回null
	 */
	User finUserByNameAndPsw(String username, String password);
	
	/**
	 * 根据用户id查找用户
	 * @param i
	 * @return 用户bean
	 */
	User findUserById(int i);
	
	/**
	 * 列举出所有的用户
	 * @return
	 */
	List<User> getAllUsers();
	

	

}
