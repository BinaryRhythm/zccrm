package com.ccit.dao;

import java.io.Serializable;
import java.sql.SQLException;

import com.ccit.page.PageDiv;

public interface CustomerDao<Customer extends Serializable> {

	public void addCustomer(Customer c) throws SQLException;

	public void deleteCustomer(Integer id) throws SQLException;

	public void updateCustomer(Customer Customer) throws SQLException;

	public Customer getCustomer(Integer id) throws SQLException;

	/**
	 * 获取所有客户
	 * 
	 * @param pageSize 每页显示的记录数目
	 * @param pageNo  页码，从1开始
	 * @return 返回所有客户，是指定的分页结果
	 * @throws SQLException
	 */
	public PageDiv<Customer> getAllCustomer(Integer pageSize, Integer pageNo)
			throws SQLException;

	/**
	 * 依据员工id获取客户的分页结果
	 * 
	 * @param pageSize
	 * @param pageNo
	 * @param staffId 员工的ID
	 * @return
	 * @throws SQLException
	 */
	public PageDiv<Customer> getCustomerByStaff(Integer pageSize,
			Integer pageNo, Integer staffId) throws SQLException;

	/**
	 * 通过区域获取所有客户
	 * 
	 * @param pageSize
	 * @param pageNo
	 * @param areaId
	 * @return
	 * @throws SQLException
	 */
	public PageDiv<Customer> getCustomerByArea(Integer pageSize,
			Integer pageNo, Integer areaId) throws SQLException;

	/**
	 * 通过区域和员工获取客户
	 * 
	 * @param pageSize
	 * @param pageNo
	 * @param staffId
	 * @param areaId
	 * @return
	 * @throws SQLException
	 */
	public PageDiv<Customer> getCustomerByStaffAndArea(Integer pageSize,
			Integer pageNo, Integer staffId, Integer areaId)
			throws SQLException;

	/**
	 * 查找下属员工的所有客户
	 * @param pageSize
	 * @param pageNo
	 * @param leaderId
	 * @return
	 * @throws SQLException
	 */
	public PageDiv<Customer> getCustomerByUnderStaff(Integer pageSize,
			Integer pageNo, Integer leaderId) throws SQLException;
}
