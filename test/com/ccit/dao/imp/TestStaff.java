package com.ccit.dao.imp;

import java.util.List;

import org.junit.Test;

import com.ccit.beans.Staff;
import com.ccit.dao.StaffDao;
import com.ccit.dao.core.DaoFactory;
import com.ccit.page.PageDiv;

public class TestStaff {
	
	@Test
	public void testAddStaff(){
		StaffDao<Staff> sd = (StaffDao<Staff>)DaoFactory.getDao("StaffDao"); 
		Staff s = new Staff();
		s.setAreaID(1);
		s.setAddr("广西湛江");
		s.setEmail("syoon@qq.com");
		s.setName("蓝力");
		s.setPwd("123446");
		s.setTel("13865808808");
		s.setLimits("测试人员");
	    sd.addStaff(s);
	}
	
	@Test
	public void testDeleteStaff(){
		StaffDao<Staff> sd = (StaffDao<Staff>)DaoFactory.getDao("StaffDao");
		sd.deleteStaff(2);
	}
	
	@Test 
	public void testUpdateStaff(){
		StaffDao<Staff> sd = (StaffDao<Staff>)DaoFactory.getDao("StaffDao");
		Staff s = new Staff();
		s.setId(4);
		s.setAreaID(4);
		s.setAddr("山东烟台");
		s.setEmail("1504537@qq.com");
		s.setName("林涵");
		s.setPwd("123446");
		s.setTel("13865808808");
		s.setLimits("测试人员");
		sd.updateStaff(s);
	}
	
	@Test
	public void testGetStaff(){
		StaffDao<Staff> sd = (StaffDao<Staff>)DaoFactory.getDao("StaffDao");
		Staff s = sd.getStaff(1);
		System.out.println(s.getName()+";"+s.getAddr());
	}
	
	@Test
	public void testGetAllStaff(){
		StaffDao<Staff> sd = (StaffDao<Staff>)DaoFactory.getDao("StaffDao");
		PageDiv<Staff> pd = sd.getAllStaff(2, 3);
		List<Staff> list = pd.getList();
		for(Staff s:list){
			System.out.println(s.getName()+";"+s.getEmail());
		}
		System.out.println("=------------------------------------");
		System.out.println("总共记录数："+pd.getTotalCount());
		System.out.println("总共页数："+pd.getTotalPage());
		System.out.println("每页多少条："+pd.getPageSize());
		System.out.println("当前页："+pd.getPageNo());
		
	}

}
