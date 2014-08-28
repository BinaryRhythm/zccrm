package com.ccit.dao.imp;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import com.ccit.beans.TrainInfo;
import com.ccit.dao.TrainInfoDao;
import com.ccit.dao.core.DaoFactory;
import com.ccit.page.PageDiv;

public class TestTrainInfo {

	@Test
	public void testAddTrainInfo() {
		TrainInfoDao tfd = (TrainInfoDao) DaoFactory
				.getDao("TrainInfoDao");
		TrainInfo ti = new TrainInfo();
		ti.setBegin(new Date());
		ti.setCar("商务车6");
		ti.setCartype("SUV");
		ti.setComment("这是备注");
		ti.setCourse("计算机算法");
		ti.setCustomerId(5);
		ti.setDriver("阳城");
		ti.setDrivertel("1234569887");
		ti.setEnd(new Date());
		ti.setLogistics("后勤科");
		ti.setLogisticstel("后勤电话");
		ti.setPlace("国防科大一号院");
		ti.setProject("培训项目");
		ti.setTeacher("李暾");
		ti.setTeachertel("45974348");
		ti.setTrainer("教练");
		ti.setTrainercount(13);
		ti.setTrainertel("教练电话");
		ti.setTrainleader("受训方领队");
		ti.setTrainleaderbirth("受训方生日");
		ti.setTrainleadertel("领队电话");

		try {
			tfd.addTrainInfo(ti);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteTrainInfo() {
		TrainInfoDao tfd = (TrainInfoDao) DaoFactory
				.getDao("TrainInfoDao");
		try {
			tfd.deleteTrainInfo(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateTrainInfo() {
		TrainInfoDao tfd = (TrainInfoDao) DaoFactory
				.getDao("TrainInfoDao");

		TrainInfo ti = new TrainInfo();
		ti.setBegin(new Date());
		ti.setCar("商务车6");
		ti.setCartype("SUV");
		ti.setComment("这是备注");
		ti.setCourse("计算机图形学");
		ti.setCustomerId(5);
		ti.setDriver("陈氏百");
		ti.setDrivertel("1234569887");
		ti.setEnd(new Date());
		ti.setLogistics("后勤科");
		ti.setLogisticstel("后勤电话");
		ti.setPlace("国防科大一号院");
		ti.setProject("培训项目");
		ti.setTeacher("李暾");
		ti.setTeachertel("45974348");
		ti.setTrainer("教练");
		ti.setTrainercount(13);
		ti.setTrainertel("教练电话");
		ti.setTrainleader("受训方领队");
		ti.setTrainleaderbirth("受训方生日");
		ti.setTrainleadertel("领队电话");
		ti.setId(3);

		try {
			tfd.updateTrainInfo(ti);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetTrainInfo() {
		TrainInfoDao tfd = (TrainInfoDao) DaoFactory
				.getDao("TrainInfoDao");
		try {
			TrainInfo ti = tfd.getTrainInfo(3);
			System.out.println(ti.getTeacher());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllTrainInfo() {
		TrainInfoDao tfd = (TrainInfoDao) DaoFactory
				.getDao("TrainInfoDao");
		try {
			PageDiv<TrainInfo> pd = tfd.getAllTrainInfo(2, 1);
			for (TrainInfo t : pd.getList()) {
				System.out.println(t.getCourse());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetTrainInfoByCustomer(){
		TrainInfoDao tfd = (TrainInfoDao) DaoFactory
				.getDao("TrainInfoDao");
		try {
			PageDiv<TrainInfo> pd = tfd.getTrainInfoByCustomer(2, 1, 3);
			for (TrainInfo t : pd.getList()) {
				System.out.println(t.getCourse());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
