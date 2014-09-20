package com.ccit.service.imp;

import org.junit.Test;

import com.ccit.beans.Staff;
import com.ccit.service.StaffService;
import com.ccit.service.core.ServiceFactory;

public class TestStaffServiceImp {

	@Test
	public void testRegister(){
		StaffService ss = (StaffService)
				ServiceFactory.getService("StaffService");
		
		Staff s = new Staff();
		s.setAreaID(1);
		s.setAddr("广西北海");
		s.setEmail("syoon@gmail.com");
		s.setName("无缘");
		s.setPwd("123446");
		s.setTel("13865808808");
		s.setLimits("报告人员");
		
		System.out.println(ss.registStaff(s));
	}
	
	@Test
	public void testGetIdByName(){
		StaffService ss = (StaffService)
				ServiceFactory.getService("StaffService");
		int id = ss.getIdByName("李长坤");
		System.out.println(id);
	}
	
}
