package com.ccit.dao;

import java.io.Serializable;
import java.sql.SQLException;

public interface Dao<T extends Serializable> {

	// 基本数据库操作 ：add delete update get
	public void add(T t) throws SQLException;

	public void delete(Integer id) throws SQLException;

	public void update(T t) throws SQLException;

	public T get(Integer id) throws SQLException;

}
