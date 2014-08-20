package com.ccit.dao.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 对connection事务封装一个事务管理类
 * 
 * @author BinaryRhythm
 * @version 1.0
 */
public class TransactionManager implements InvocationHandler {

	private Object target = null;
	private ThreadLocal<Connection> cons = new ThreadLocal<Connection>();

	/**
	 * 注入要生成的代理对象
	 * 
	 * @param target
	 */
	public TransactionManager(Object target) {
		this.target = target;
	}

	/**
	 * 获取当前用户所使用的connnection
	 * 
	 * @return
	 */
	public Connection getConnection() {
		Connection conn = cons.get();
		if (null == conn) {
			conn = ConnectionManager.getInstance().getConnection();
		}
		return conn;
	}

	public void begin() {
		try {
			if (getConnection().getAutoCommit()) {
				getConnection().setAutoCommit(false);
			}
			cons.set(getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void commit() {
		try {
			getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void rollback() {
		try {
			getConnection().rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 为目标对象的方法增加事务，
	 * 此方法是一个InvocationHandler接口中的方法，为生成代理对象扩展功能
	 */
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
		Object result = null;
		String name = arg1.getName();
		if (name.startsWith("get")) {
			result = arg1.invoke(target, arg2);
		} else {
			this.begin();
			try {
				result = arg1.invoke(target, arg2);
				this.commit();
			} catch (Exception e) {
				this.rollback();
				e.printStackTrace();
			}
		}
		return result;
	}

}
