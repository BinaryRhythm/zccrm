package com.ccit.dao.core;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

/**
 * 数据库操作的基本接口，方便数据库的操作
 * @author BinaryRhythm
 * @version 1.0
 * @param <T> 对应表的实体类POJO
 */
public interface BaseDao<T extends Serializable>{
	
	/**
	 * 获取当前数据库连接
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException;
	
	/**
	 * 批量执行sql语句，将一条sql重复多次
	 * demo:delete from tbl_name where id=? and **=?
	 * @param sql 要批量执行的sql语句
	 * @param params 传入的参数为二维数组
	 * @return 一维数组，为每条sql语句影响的的数据表条数
	 * @throws SQLException
	 */
	public int[] batch(String sql,Object[][] params) throws SQLException;
	
	/**
	 * 执行sql语句，执行一次
	 * 包括：insert update delete
	 * @param 
	 * @return 返回影响数据表的条数
	 * @throws SQLException
	 */
	public int executeUpdate(String sql) throws SQLException;
	
	/**
	 * 更新数据表
	 * 包括：insert,update,delete
	 * @param sql 
	 * @param params 加入的参数
 	 * @return
	 * @throws SQLException
	 */
	public int executeUpdate(String sql,Object... params) throws SQLException;
	
	/**
	 * 查询指定sql所查找的记录总数，sql语句一定要以select count（*）开头
	 * @param sql
	 * @return 返回记录总条数
	 * @throws SQLException
	 */
	public int executeQueryForCount(String sql) throws SQLException;

	/**
	 * 查询一条记录，如果查到多条记录，则返回第一条
	 * @param sql
	 * @param clazz 指定了返回对象类型
	 * @return 返回第一条记录的对象封装
	 * @throws SQLException
	 */
	public T executeQueryForBean(String sql,Class<T> clazz) throws SQLException;
	
	/**
	 * 查询一条记录，如果查到多条，则返回第一条
	 * demo:select * from user where id=?
	 * @param sql
	 * @param clazz
	 * @param params 用来替代？的参数
	 * @return
	 * @throws SQLException
	 */
	public T executeQueryForBean(String sql,Class<T> clazz,Object...params) throws SQLException;
	
	/**
	 * 查询数据表，将返回结果转成List
	 * demo：List<User> = select * from user；
	 * @param sql
	 * @param clazz 返回列表中元素的类型
	 * @return
	 * @throws SQLException
	 */
	public List<T> executeQuery(String sql,Class<T> clazz) throws SQLException;
	public List<T> executeQuery(String sql,Class<T> clazz,Object...params) throws SQLException;
	
	/**
	 * 查询表，将每条结果封装为objectp[]投影查询，用于查找一个表的部分数据
	 * @param sql
	 * @param params 代替sql语句中的？
	 * @return
	 * @throws SQLException
	 */
	public List<Object[]> executeRawQuery(String sql,Object...params) throws SQLException;
	
	public Object query(String sql,ResultSetHandler<T> rsh) throws SQLException;
	public Object query(String sql,ResultSetHandler<T> rsh,Object...params) throws Exception;
	
	
	
	
}
