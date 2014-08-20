package com.ccit.dao.core;

import java.io.Serializable;

public class DaoTemplate<T extends Serializable> {
	
	protected BaseDao<T> dao = new BaseDaoImp<T>();
	
	public BaseDao<T> getDao() {
		return dao;
	}
	
	public void setDao(BaseDao<T> dao){
		this.dao = dao;
	}
}
