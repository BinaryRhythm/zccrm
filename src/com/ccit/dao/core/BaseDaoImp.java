package com.ccit.dao.core;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 * 数据库操作基本接口类BaseDao的实现类，完成了操作数据库的一般方法
 * 
 * @author BinaryRhythm
 * @version 1.0
 * @param <T>
 */
public class BaseDaoImp<T extends Serializable> implements BaseDao<T> {

	private QueryRunner qr = new QueryRunner();
	private Connection conn = ConnectionManager.getInstance().getConnection();

	@Override
	public int[] batch(String sql, Object[][] params) throws SQLException {
		return qr.batch(conn,sql, params);
	}

	@Override
	public int executeUpdate(String sql) throws SQLException {
		return qr.update(conn,sql);
	}

	@Override
	public int executeUpdate(String sql, Object... params) throws SQLException {
		return qr.update(conn,sql, params);
	}

	@Override
	public int executeQueryForCount(String sql) throws SQLException {
		Integer i = 0;
		if (sql.matches("^select\\s+count.+")) {
			Object[] temp = qr.query(conn, sql, new ArrayHandler());
			if (null != temp && temp.length > 0) {
				String str = temp[0].toString();
				if (str.matches("\\d+")) {
					i = Integer.parseInt(str);
				}
			}
		}
		return i;
	}

	@Override
	public T executeQueryForBean(String sql, Class<T> clazz)
			throws SQLException {
		return qr.query(conn, sql, new BeanHandler<T>(clazz));
	}

	@Override
	public T executeQueryForBean(String sql, Class<T> clazz, Object... params)
			throws SQLException {
		return qr.query(conn, sql, new BeanHandler<T>(clazz), params);
	}

	@Override
	public List<T> executeQuery(String sql, Class<T> clazz) throws SQLException {
		return qr.query(conn, sql, new BeanListHandler<T>(clazz));
	}

	@Override
	public List<T> executeQuery(String sql, Class<T> clazz, Object... params)
			throws SQLException {
		return qr.query(conn, sql, new BeanListHandler<T>(clazz), params);
	}

	@Override
	public List<Object[]> executeRawQuery(String sql, Object... params)
			throws SQLException {
		return qr.query(conn, sql, new ArrayListHandler(), params);
	}

	@Override
	public Object query(String sql, ResultSetHandler<T> rsh)
			throws SQLException {
		return qr.query(conn, sql, rsh);
	}

	@Override
	public Object query(String sql, ResultSetHandler<T> rsh, Object... params)
			throws Exception {
		return qr.query(conn, sql, rsh, params);
	}

	@Override
	public Connection getConnection() throws SQLException {
		return conn;
	}

}
