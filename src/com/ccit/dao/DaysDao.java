package com.ccit.dao;

import java.io.Serializable;
import java.sql.SQLException;

public interface DaysDao<Days extends Serializable> {

	public void addDays(Days c) throws SQLException;

	public void deleteDays(Integer id) throws SQLException;

	public void updateDays(Days Days) throws SQLException;

	public Days getDays(Integer id) throws SQLException;
	
	/**
	 * 根据员工id获取提醒天数
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Days getDaysByStaff(Integer id) throws SQLException;

}
