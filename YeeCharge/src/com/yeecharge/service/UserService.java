package com.yeecharge.service;

import java.util.List;
import com.yeecharge.domain.User;
import com.yeecharge.annotation.Tran;

public interface UserService extends Service {
	/**
	 * 注册用户
	 * @param user 封装了user信息的userbean
	 */
	@Tran
	void regist(User user);

	
	/**
	 * 根据激活码激活用户
	 * @param activecode
	 * @return User
	 */
	void activeUser(String activecode);

	/**
	 * 根据用户名和密码查找用户
	 * @param username
	 * @param password
	 * @return   如果找到返回User 找不到返回null
	 */
	User getUserByNameAndPsw(String username, String password);
	
	/**
	 * （admin权限专用）
	 * 	列出所有的用户信息
	 * @return user
	 */
	List<User> getUsersList();
	
	/**
	 * 根据用户的id删除用户
	 * @param id
	 */
	void deleteUserById(String id);

	/**
	 * 根据用户id返回对应用户的信息
	 * @return user domain
	 */
	User getUser(String id);

	/**
	 * 查询传入的用户名是否已经存在，若已经存在，则返回true，否则返回false
	 * @param username
	 * @return
	 */
	boolean hasName(String username);

	
}
