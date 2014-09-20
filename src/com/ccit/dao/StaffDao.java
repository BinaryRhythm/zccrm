package com.ccit.dao;

import java.io.Serializable;
import java.sql.SQLException;

import com.ccit.page.PageDiv;

/**
 * 操作员工数据表的接口
 * 
 * @author BinaryRhythm
 *
 * @param <Staff>
 */
public interface StaffDao<Staff extends Serializable> {

	public void addStaff(Staff s) throws SQLException;

	public void deleteStaff(Integer id) throws SQLException;

	public void updateStaff(Staff s) throws SQLException;

	public Staff getStaff(Integer id) throws SQLException;
	
	public Integer getIdByName(String name) throws SQLException;

	/**
	 * 分页查找所有员工
	 * 
	 * @param pageSize
	 *            每页条数
	 * @param pageNo
	 *            当前要第几页
	 * @return
	 */
	public PageDiv<Staff> getAllStaff(Integer pageSize, Integer pageNo)
			throws SQLException;

	/**
	 * 根据区域查找员工
	 * 
	 * @param pageSize
	 * @param pageNo
	 * @param areaID
	 * @return
	 */
	public PageDiv<Staff> getStaffByArea(Integer pageSize, Integer pageNo,
			Integer areaID) throws SQLException;

	/**
	 * 根据领导id查找员工
	 * 
	 * @param pageSize
	 * @param pageNo
	 * @param leaderID
	 * @return
	 */
	public PageDiv<Staff> getStaffByleader(Integer pageSize, Integer pageNo,
			Integer leaderID) throws SQLException;

	public Staff checkLogin(String email, String pwd) throws SQLException;

	public void addUnderStaff(Integer leaderId, Integer staffId)
			throws SQLException;
	
	public PageDiv<Staff> getStaffByStatus(Integer pageSize, Integer pageNo,
			Integer state) throws SQLException;
	
	/**
	 * 获取最后一条插入记录的id
	 * @return
	 * @throws SQLException
	 */
	public Integer getLastInsertId()throws SQLException;
}
