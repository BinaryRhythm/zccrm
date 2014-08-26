package com.ccit.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import com.ccit.page.PageDiv;

public interface ReportDao<Report extends Serializable> {

	public void addReport(Report r) throws SQLException;

	public void deleteReport(Integer id) throws SQLException;

	public void updateReport(Report r) throws SQLException;

	public Report getReport(Integer id) throws SQLException;

	/**
	 * 通过客户来查找报告
	 * 
	 * @param customerId
	 * @return
	 * @throws SQLException
	 */
	public Report getReportByCustomer(Integer customerId) throws SQLException;

	/**
	 * 获取到所有报告
	 * 
	 * @return
	 * @throws SQLException
	 */
	public PageDiv<Report> getAllReport(Integer pageSize, Integer pageNo)
			throws SQLException;

	/**
	 * 通过状态查找报告
	 * 
	 * @param status
	 * @return
	 * @throws SQLException
	 */
	public PageDiv<Report> getReportByStatus(Integer pageSize, Integer pageNo,
			Integer status) throws SQLException;

}
