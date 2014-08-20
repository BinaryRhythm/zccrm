package com.ccit.dao.core;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * 用来管理connection的一个抽象类
 * @author BinaryRhythm
 *@version 1.0
 */
public abstract class ConnectionManager {
	
	static Logger log = Logger.getLogger(ConnectionManager.class);
	private static ThreadLocal<Connection> localCon = new ThreadLocal<Connection>();
	private static ResourceBundle jdbc = ResourceBundle.getBundle("jdbc");
    static final String CONNECTION_MANAGER = "connectionManager";
    private Connection conn = null;
    
    /**
     * 得到一个连接对象
     * @return
     */
    public Connection getConnection(){
    	conn = localCon.get();
    	if(null == conn){
    		try{
    			conn = this.getRealConnection();
    			localCon.set(conn);
    		}catch(Exception e){
    			log.error("无法得到数据库连接对象");
    			e.printStackTrace();
    		}
    	}
    	return conn;
    }
	
    /**
     * 由子类实现，返回一个Connection对象
     * @return
     * @throws Exception
     */
    public abstract Connection getRealConnection() throws Exception;
    
    /**
     * 得到当前抽象类的一个对象ConnectionManager，读取src下的jdbc.properties来实例化ConnectionManager
     * @return
     */
	public static ConnectionManager getInstance(){
		ConnectionManager cm = null;
		String conmanager = jdbc.getString(CONNECTION_MANAGER); // 类名
		if(null == conmanager){
			log.error("找不到connectionManager的配置，请检查jdbc.properties文件中的connectionManager项");
		}else{
			try{
				// 实际取得的是c3p0ConnectionManager的实例 ，子类对象给父类
				cm = (ConnectionManager)Class.forName(conmanager).newInstance();
			}catch(Exception e){
				log.error("找不到conmanager的配置，请检查jdbc.properties中connectionManager");
				e.printStackTrace();
			}
		}
		return cm;
	}
	
	/**
	 * 重置连接
	 * @param con
	 */
	public void setConnection(Connection con){
		this.conn = con;
		localCon.set(con);
	}

	/**
	 * 关闭connection
	 */
	public void closeConnection(){
		if(null != conn){
			try{
				if(!conn.isClosed()){
					conn.close();
				}
				if(conn.isClosed()){
					localCon.remove();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
