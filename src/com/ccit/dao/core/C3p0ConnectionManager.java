package com.ccit.dao.core;

import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0ConnectionManager extends ConnectionManager{

	@Override
	public Connection getRealConnection() throws Exception{
		return new ComboPooledDataSource().getConnection();
	}
}
