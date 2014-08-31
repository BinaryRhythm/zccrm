package com.ccit.dao;

import java.io.Serializable;
import java.sql.SQLException;

import com.ccit.page.PageDiv;

public interface VisitDao<Visit extends Serializable>{

	 public void addVisit(Visit v) throws SQLException;
	
	 public void deleteVisit(Integer id) throws SQLException;
	
	 public void updateVisit(Visit v) throws SQLException;
	
	 public Visit getVisit(Integer id) throws SQLException;

	/**
	 * 更具customer id 获取visit
	 * @param pageSize
	 * @param pageNo
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public PageDiv<Visit> getVisitByCustomer(Integer pageSize, Integer pageNo,
			Integer id) throws SQLException;
}
