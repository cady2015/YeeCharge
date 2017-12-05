package com.yeecharge.service;

import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.yeecharge.dao.UserDao;
import com.yeecharge.domain.User;
import com.yeecharge.factory.BasicFactory;

public class UserServiceImpl implements UserService {
	private UserDao dao  = BasicFactory.getFactory().getDao(UserDao.class);
	
	public void regist(User user) {
		try {
			//1.校验用户名是否存在
			if(dao.findUserByName(user.getUsername())!=null){
				throw new RuntimeException("用户名已经存在！");
			}
			//2.调用dao中的方法添加用户
			user.setRole("user");
			user.setState(0);
			user.setActivecode(UUID.randomUUID().toString());
			dao.addUser(user);
		
			//3.发送激活邮件
			Properties prop = new Properties();
			prop.setProperty("mail.transport.protocol", "smtp");
			prop.setProperty("mail.smtp.host", "localhost");
			prop.setProperty("mail.smtp.auth", "true");
			prop.setProperty("mail.debug", "true");
			Session session = Session.getInstance(prop);
				//新建一个邮件对象
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("admin@yeecharge.com"));
			msg.setRecipient(RecipientType.TO, new InternetAddress(user.getEmail()));
			msg.setSubject(user.getUsername()+",来自yeecharge的激活邮件");
			msg.setText("点击如下链接激活账户，如果不能点击请复制到浏览器地址栏访问：http://cady20151231.imwork.net/ActiveServlet?activecode="+user.getActivecode());
			
			Transport trans = session.getTransport();
			trans.connect("admin", "123");
			trans.sendMessage(msg, msg.getAllRecipients());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void activeUser(String activecode) {
		//1.调用dao根据激活码查找用户
		User user = dao.findUserByActivecode(activecode);
		//2.激活码不正确，不允许激活
		if(user==null){
			throw new RuntimeException("激活码不存在！请检查您的激活码！");
		}
		//3.用户已经激活过，不要重复激活
		if(user.getState()!=0){
			throw new RuntimeException("用户已经激活过，不要重复激活!");
		}//4.激活码已经过期，提示重新激活
		if(System.currentTimeMillis()-user.getUpdatetime().getTime() >1000*3600*24){
			throw new RuntimeException("激活码已经过期，请重新激活");
		}
		//5.调用dao中修改用户激活状态的方法
		dao.updateState(user.getId(),1);
	}
	public User getUserByNameAndPsw(String username, String password) {
		return dao.finUserByNameAndPsw(username,password);
	}

	public List<User> getUsersList() {
		List<User> list = dao.getAllUsers();
		return list;
	}

	public void deleteUserById(String id) {
		dao.delUser(new Integer(id));
	}

	public User getUser(String id) {
		return dao.findUserById(new Integer(id));
	}

	public boolean hasName(String username) {
		return dao.findUserByName(username)!=null;
	}


}
