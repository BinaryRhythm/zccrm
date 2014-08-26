package com.ccit.dao.imp;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import com.ccit.beans.Report;
import com.ccit.dao.ReportDao;
import com.ccit.dao.core.DaoFactory;
import com.ccit.page.PageDiv;

public class TestReport {

	@Test
	public void testAddReport() {
		Report r = new Report();
		r.setComment("备注");
		r.setCustomerId(5);
		r.setDates(new Date());
		r.setName("刘平");
		r.setStatus(1);
		r.setTitile("课题研究");
		r.setTrain_id(1);
		ReportDao<Report> dao = (ReportDao<Report>) DaoFactory
				.getDao("ReportDao");
		try {
			dao.addReport(r);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteReport() {
		ReportDao<Report> dao = (ReportDao<Report>) DaoFactory
				.getDao("ReportDao");
		try {
			dao.deleteReport(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateReport() {
		ReportDao<Report> dao = (ReportDao<Report>) DaoFactory
				.getDao("ReportDao");

		Report r = new Report();
		r.setId(3);
		r.setComment("备注");
		r.setCustomerId(5);
		r.setDates(new Date());
		r.setName("拿破仑");
		r.setStatus(1);
		r.setTitile("乡镇领导班子考核");
		r.setTrain_id(1);

		try {
			dao.updateReport(r);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetReport() {
		ReportDao<Report> dao = (ReportDao<Report>) DaoFactory
				.getDao("ReportDao");
		try {
			Report r = dao.getReport(3);
			System.out.println(r.getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllReport() {
		ReportDao<Report> dao = (ReportDao<Report>) DaoFactory
				.getDao("ReportDao");
		try {
			PageDiv<Report> pd = dao.getAllReport(3, 1);
			for (Report r : pd.getList())
				System.out.println(r.getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetReportByStatus(){
		ReportDao<Report> dao = (ReportDao<Report>) DaoFactory
				.getDao("ReportDao");
		try {
			PageDiv<Report> pd = dao.getReportByStatus(2, 1, 1);
			for(Report r : pd.getList()){
				System.out.println(r.getName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
