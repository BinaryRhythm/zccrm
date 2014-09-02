package com.ccit.service.imp;

import java.sql.SQLException;

import com.ccit.beans.Staff;
import com.ccit.page.PageDiv;
import com.ccit.service.ManagerService;
import com.ccit.service.core.ServiceBase;

public class ManagerServiceImp extends ServiceBase implements ManagerService {

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

}
