package com.ccit.service;

import java.util.List;

import com.ccit.beans.Area;
import com.ccit.beans.Customer;
import com.ccit.beans.Days;
import com.ccit.beans.KeyPerson;
import com.ccit.beans.Report;
import com.ccit.beans.Staff;
import com.ccit.beans.TrainInfo;
import com.ccit.beans.TrainUser;
import com.ccit.beans.Visit;
import com.ccit.page.PageDiv;

public interface StaffService {

	// **************** 员工相关功能

	/**
	 * 用户登录验证
	 * 
	 * @param email
	 * @param pwd
	 * @return 成功返回staff对象，否则null
	 */
	public Staff checkLogin(String email, String pwd);

	/**
	 * 新员工注册，每注册一个新员工都生成一条提醒天数的记录， 一对一默认客户生日提醒和企业周年提醒都为7天
	 * 
	 * @param s
	 * @return
	 */
	public boolean registStaff(Staff s);

	/**
	 * 根据员工id查询员工
	 * 
	 * @param id
	 * @return
	 */
	public Staff getStaff(Integer id);

	/**
	 * 修改员工信息
	 * 
	 * @param staff
	 * @return
	 */
	public boolean modifyStaffInfo(Staff staff);

	/**
	 * 查找所有区域的列表
	 * 
	 * @return
	 */
	public List<Area> getAllArea();

	/**
	 * 根据用户ID查出更新天数数据
	 * 
	 * @param staffId
	 * @return
	 */
	public Days getDays(Integer staffId);

	/**
	 * 设置提醒天数
	 * 
	 * @param days
	 * @return
	 */
	public boolean setAlertDays(Days days);

	/**
	 * 添加潜在客户或现有客户
	 * 
	 * @param c
	 * @return
	 */
	public boolean addCustomer(Customer c);

	/**
	 * 根据客户id查找客户
	 * 
	 * @param id
	 * @return
	 */
	public boolean getCustomer(Integer id);

	/**
	 * 修改客户资料
	 * 
	 * @param c
	 * @return
	 */
	public boolean updateCustomer(Customer c);

	/**
	 * 根据员工id 查找客户
	 * 
	 * @param pageSize
	 * @param pageNo
	 * @param staffId
	 * @return
	 */
	public PageDiv<Customer> getCustomerByStaff(Integer pageSize,
			Integer pageNo, Integer staffId);

	/**
	 * 根据下属员工id查找客户
	 * 
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public PageDiv<Customer> getCustomerBySubStaff(Integer pageSize,
			Integer pageNo, Integer leaderId);

	// ******************** 关键人物相关功能
	public boolean addKeyPerson(KeyPerson keyPerson);

	public boolean deleteKeyPerson(Integer id);

	public boolean updateKeyPerson(KeyPerson kp);

	public KeyPerson getKeyPerson(Integer id);

	public List<KeyPerson> getKeyPersonByCustomer(Integer customerId);

	// ******************* 拜访记录相关
	public boolean addVisit(Visit v);

	public boolean deleteVisit(Integer id);

	public boolean updateVisit(Visit v);

	public Visit getVisit(Integer id);

	public List<Visit> getVisitByCustomer(Integer customerId);

	public PageDiv<Visit> getVisitByCustomer(Integer pageSize, Integer pageNo,
			Integer customerId);

	// ************* 培训登记相关
	public boolean addTrainInfo(TrainInfo trainInfo);

	public boolean deleteTrainInfo(Integer id);

	public boolean updateTrainInfo(TrainInfo trainInfo);

	public TrainInfo getTrainInto(Integer id);

	public List<TrainInfo> getTrainInfoByCustomer(Integer customerId);

	public PageDiv<TrainInfo> getTrainInfoByCustomer(Integer pageSize,
			Integer pageNo, Integer customerId);

	// ***************** 培训登记相关
	public boolean addTrainUser(TrainUser tu);

	public boolean deleteTrainUser(Integer id);

	public boolean updateTrainUser(TrainUser tu);

	public TrainUser getTrainUser(Integer id);

	public PageDiv<TrainUser> getTrainUserByTrainInfo(Integer pageSize,
			Integer pageNo, Integer trainInfoId);

	// *************** 报告相关
	public boolean addReport(Report r);

	public boolean deleteReport(Integer id);

	public boolean updateReport(Report r);

	public Report getReport(Integer id);

	public PageDiv<Report> getAllReport(Integer pageSize, Integer pageNo);

	public PageDiv<Report> getReportByStatus(Integer pageSize, Integer pageNo,
			Integer statusId);
}
