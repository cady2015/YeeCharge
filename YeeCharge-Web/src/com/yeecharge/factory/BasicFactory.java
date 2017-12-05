package com.yeecharge.factory;

import java.io.FileReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Properties;

import com.yeecharge.annotation.Tran;
import com.yeecharge.dao.Dao;
import com.yeecharge.service.Service;
import com.yeecharge.util.TransactionManager;

public class BasicFactory {
	private static BasicFactory factory = new BasicFactory();
	private static Properties prop = null;
	private BasicFactory() {
	}
	static{
		try {
			prop = new Properties();
			prop.load(new FileReader(BasicFactory.class.getClassLoader().getResource("config.properties").getPath()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public static BasicFactory getFactory(){
		return factory;
	}
	
	public <T extends Dao> T getDao(Class<T> clazz){
		try {
			//获取传入对象的类名
			String infName = clazz.getSimpleName();
			//通过类名在配置文件中查找对应的实现类
			String implName = prop.getProperty(infName);
			//新创建一个实例之后返回
			return (T) Class.forName(implName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public <T extends Service> T getService(Class<T> clazz){
		try {
			//获取传入对象的类名
			String infName = clazz.getSimpleName();
			//通过类名在配置文件中查找对应的实现类
			String implName = prop.getProperty(infName);
			final T service = (T) Class.forName(implName).newInstance();
			
			//---代理service---根据判断是否有 @Tran注解 来确定是否管理事务
			@SuppressWarnings("unchecked")
			T ProxyService = (T) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(),new InvocationHandler() {
				
				public Object invoke(Object proxy, Method method, Object[] args)
						throws Throwable {
					if(method.isAnnotationPresent(Tran.class)){//--如果有注解则管理事务
						try{
							//1.在方法执行之前要干的事--开启事务
							TransactionManager.startTran();
							//2.方法执行
							Object obj = method.invoke(service, args);
							//3.在方法执行之后要干的事--提交事务
							TransactionManager.commit();
							return obj;
						}catch (InvocationTargetException e) {
							TransactionManager.rollback();//4.在方法失败之后--回滚事务
							throw new RuntimeException(e.getTargetException());
						}catch (Exception e) {
							TransactionManager.rollback();
							throw new RuntimeException(e);
						}finally{//5.在方法执行结尾--释放资源
							TransactionManager.release();
						}
					}else
						return method.invoke(service, args);
				}
			});
			//返回代理对象
			return ProxyService;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
