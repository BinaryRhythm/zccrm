package com.ccit.service.imp;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ccit.beans.Staff;
import com.ccit.page.PageDiv;
import com.ccit.service.ManagerService;
import com.ccit.service.StaffService;
import com.ccit.service.core.ServiceBase;

public class ManagerServiceImp extends ServiceBase implements ManagerService {

	private static final Logger log = Logger.getLogger(StaffService.class);

	@Override
	public PageDiv<Staff> getAllStaff(Integer pageSize, Integer pageNo) {
		PageDiv<Staff> pd = null;
		try {
			pd = staffDao.getAllStaff(pageSize, pageNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pd;
	}

	@Override
	public PageDiv<Staff> getStaffByArea(Integer pageSize, Integer pageNo,
			Integer areaId) {
		PageDiv<Staff> pd = null;
		try {
			pd = staffDao.getStaffByArea(pageSize, pageNo, areaId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pd;
	}

	@Override
	public PageDiv<Staff> getStaffByLeader(Integer pageSize, Integer pageNo,
			Integer leaderId) {
		PageDiv<Staff> pd = null;

		try {
			pd = staffDao.getStaffByleader(pageSize, pageNo, leaderId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pd;
	}

	@Override
	public void deleteStaff(Integer id) {
		try {
			staffDao.deleteStaff(id);
			log.info("删除员工");
		} catch (SQLException e) {
			log.info("删除员工失败", e);
			e.printStackTrace();
		}
	}

	@Override
	public PageDiv<Staff> getStaffByStatus(Integer pageSize, Integer pageNo,
			Integer state) {
		PageDiv<Staff> pd = null;
		try {
			pd = staffDao.getStaffByStatus(pageSize, pageNo, state);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pd;
	}

}
