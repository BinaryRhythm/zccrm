package com.ccit.dao.imp;

import java.util.List;

import org.junit.Test;

import com.ccit.beans.Area;
import com.ccit.dao.AreaDao;
import com.ccit.service.StaffService;
import com.ccit.service.core.ServiceFactory;

public class TestArea {

	@Test
	public void testAddArea() {
		AreaDao<Area> ad = new AreaDaoImp();

		Area a = new Area();
		a.setName("西北");
		a.setStatus(1);
		ad.addArea(a);
	}

	@Test
	public void testdeleteArea() {
		AreaDao<Area> ad = new AreaDaoImp();
		ad.deleteArea(5);
	}

	@Test
	public void testupdateArea() {
		AreaDao<Area> ad = new AreaDaoImp();
		Area a = new Area();
		a.setName("东南");
		a.setStatus(0);
		a.setId(4);
		ad.updateArea(a);
	}

	@Test
	public void testgetArea() {
		AreaDao<Area> ad = new AreaDaoImp();
		Area a = ad.getArea(3);
		if (null != a)
			System.out.println(a.getName() + " " + a.getStatus());
	}

	@Test
	public void testgetAll() {
		AreaDao<Area> ad = new AreaDaoImp();
		List<Area> list = ad.getAll();
		for (Area a : list) {
			System.out.println(a.getName() + "," + a.getStatus() + "\n");
		}
	}
	
	
	//// test  service
	@Test
	public void testService(){
		StaffService ss = (StaffService)ServiceFactory.getService("StaffService");
		List<Area> list = ss.getAllArea();
		for(Area a:list){
			System.out.println(a.getName()+";"+a.getStatus());
		}
	}
}
