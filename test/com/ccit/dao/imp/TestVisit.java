package com.ccit.dao.imp;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import com.ccit.beans.Visit;
import com.ccit.dao.Dao;
import com.ccit.dao.VisitDao;
import com.ccit.dao.core.DaoFactory;
import com.ccit.page.PageDiv;

public class TestVisit {

	@Test
	public void testAdd() {
		Dao<Visit> vd = (Dao<Visit>) DaoFactory.getDao("VisitDao");
		Visit v = new Visit();
		v.setComment("备注");
		v.setCustomerId(3);
		v.setDates(new Date());
		v.setJdr("接待人刘平");
		v.setJqr("接洽人 何勇");
		v.setRecord("记录");
		try {
			vd.add(v);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		Dao<Visit> vd = (Dao<Visit>) DaoFactory.getDao("VisitDao");
		try {
			vd.delete(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		Dao<Visit> vd = (Dao<Visit>) DaoFactory.getDao("VisitDao");
		Visit v = new Visit();
		v.setComment("备注");
		v.setCustomerId(3);
		v.setDates(new Date());
		v.setJdr("接待人林丽丽");
		v.setJqr("接洽人 何勇");
		v.setRecord("记录");
		v.setId(3);
		try {
			vd.update(v);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGet() {
		Dao<Visit> dao = (Dao<Visit>) DaoFactory.getDao("VisitDao");
		try {
			Visit v = dao.get(3);
			System.out.println(v.getJdr());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetVisitByCustomer() {
		VisitDao<Visit> vd = (VisitDao<Visit>) DaoFactory.getDao("VisitDao");
		try {
			PageDiv<Visit> pd = vd.getVisitByCustomer(3, 1, 3);
			for (Visit v : pd.getList()) {
				System.out.println(v.getJdr());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
