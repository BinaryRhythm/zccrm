package com.ccit.dao.imp;

import java.sql.SQLException;

import org.junit.Test;

import com.ccit.beans.Days;
import com.ccit.dao.DaysDao;
import com.ccit.dao.core.DaoFactory;

public class TestDays {
	
	@Test
	public void testAddDays(){
		DaysDao<Days> dd = (DaysDao<Days>)DaoFactory.getDao("DaysDao");
		Days d = new Days();
		d.setStaffID(1);
		d.setDays1(1);
		d.setDays2(54);
		try {
			dd.addDays(d);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testDeleteDays(){
		DaysDao<Days> dd = (DaysDao<Days>)DaoFactory.getDao("DaysDao");
		try {
			dd.deleteDays(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateDays(){
		DaysDao<Days> dd = (DaysDao<Days>)DaoFactory.getDao("DaysDao");
		Days d = new Days();
		d.setId(3);
        d.setStaffID(3);
        d.setDays1(2);
        d.setDays2(68);
		try {
			dd.updateDays(d);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetDays(){
		DaysDao<Days> dd = (DaysDao<Days>)DaoFactory.getDao("DaysDao");
		try {
			Days d = dd.getDays(3);
			System.out.println(d.getDays1());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testGetDaysByStaff(){
		DaysDao<Days> dd = (DaysDao<Days>)DaoFactory.getDao("DaysDao");
		try {
			Days d = dd.getDaysByStaff(3);
			System.out.println(d.getDays1());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
