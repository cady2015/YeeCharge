package com.yeecharge.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * 解耦类，将connection交给第三方管理
 * 
 * 	ThreadLocal + 注解 实现事务管理
	工厂类 + 动态代理 实现面向切面编程
	利用动态代理,使dao中不需要区分是否开启过事务
 * @author dxf
 *
 */
public class TransactionManager {
	private TransactionManager() {
	}
	//--数据源，整个程序中只有这1个数据源(池)
	private static DataSource source = new ComboPooledDataSource();
	
	//--是否开启事务的标记
	private static ThreadLocal<Boolean> isTran_local = new ThreadLocal<Boolean>(){
		protected Boolean initialValue() {
			return false; //--最开始是false 表明不开启事务
		};
	};
	//--保存真实连接的代理连接，改造过close方法
	private static ThreadLocal<Connection> proxyConn_local = new ThreadLocal<Connection>(){};
	//--保存真实连接
	private static ThreadLocal<Connection> realConn_local = new ThreadLocal<Connection>(){};
	
	/**
	 * 开启事务
	 * @throws SQLException
	 */
	public static void startTran() throws SQLException{
		isTran_local.set(true);//--设置事务开启标记为true
		final Connection conn = source.getConnection();//--创建连接，所有当前线程中的数据库操作都基于这个conn
		conn.setAutoCommit(false);//--开启事务
		realConn_local.set(conn);//--为了方便后续关连接，将这个连接在当前线程中保存起来
		
		//--由于一个事务需要执行多条sql，每个sql执行过后都默认关闭连接，这样一来后续的sql都没法执行，
			//所以我们改造这个close方法，由是否调用真实connection的close方法决定要不要关
		Connection proxyConn = (Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(), conn.getClass().getInterfaces(), 
			new InvocationHandler() {
			
				public Object invoke(Object obj, Method method, Object[] arg2)
						throws Throwable {
					//--使其代码底层调close方法时不起作用
					if("close".equals(method.getName())){
						return null;
					}else{//--调用conn的其他方法时保持原来的方法
						return method.invoke(conn, arg2);
					}
				}
		});
		//代理连接--保存这个被改造过的connection在本地线程中
		proxyConn_local.set(proxyConn);
	}
	
	/**获取数据源(改造过的source)：
	 * 		如果没有开启过事务，则返回最普通的数据源
	 * 		如果开启过事务，则返回一个改造过getConnection方法的数据源，
	 * 	这个方法改造过后每都返回同一个开启过事务的connection
	 * @return
	 */
	public static DataSource getSource() throws SQLException{
		
		if(isTran_local.get()){//--如果开启过事务，则返回改造的DataSource,改造为每次调用
//							getConnection都返回同一个事务的conn
			return (DataSource) Proxy.newProxyInstance(source.getClass().getClassLoader()
			, source.getClass().getInterfaces() 
				,new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						if("getConnection".equals(method.getName())){
							return proxyConn_local.get();
						}else{//除getConnection之外的其他方法被调用 走这里
							return method.invoke(source, args);
						}
					}
			});
		}else{//--没有开启过事务，返回普通的数据源
			return source;
		}
	}
	
	/**
	 * 提交事务
	 */
	public static void commit(){
		DbUtils.commitAndCloseQuietly(proxyConn_local.get());
	}
	
	/**
	 * 回滚事务
	 */
	public static void rollback(){
		DbUtils.rollbackAndCloseQuietly(proxyConn_local.get());
	}
	
	/**
	 * 释放资源
	 */
	public static void release(){
		//事务结束时，需要关闭连接，这时要调用真正的 real_conn的close方法
		DbUtils.closeQuietly(realConn_local.get());
		//线程资源有限，需要释放线程
		realConn_local.remove();
		proxyConn_local.remove();
		isTran_local.remove();
	}
}
