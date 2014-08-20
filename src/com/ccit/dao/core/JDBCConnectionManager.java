package com.ccit.dao.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

/**
 * jdbc连接数据库配置
 * @author BinaryRhythm
 *
 */
public class JDBCConnectionManager extends ConnectionManager{
	
	private ResourceBundle res = ResourceBundle.getBundle("jdbc");
	private Connection conn = null;
	
	@Override
	public Connection getRealConnection() throws Exception {
		String driverClass = res.getString("driverClass");
		String jdbcUrl = res.getString("jdbcUrl");
		String user = res.getString("user");
		String pwd = res.getString("password");
		Class.forName(driverClass);
		conn = DriverManager.getConnection(jdbcUrl,user,pwd);
		return conn;
	}

}
