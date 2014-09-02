package com.ccit.service;

import com.ccit.beans.Staff;
import com.ccit.page.PageDiv;

public interface ManagerService {

	public PageDiv<Staff> getAllStaff(Integer pageSize, Integer pageNo);

	public PageDiv<Staff> getStaffByArea(Integer pageSize, Integer pageNo,
			Integer areaId);

	public PageDiv<Staff> getStaffByLeader(Integer pageSize, Integer pageNo,
			Integer areaId);

}
