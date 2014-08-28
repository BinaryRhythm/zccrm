package com.ccit.dao.imp;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import com.ccit.beans.TrainUser;
import com.ccit.dao.TrainUserDao;
import com.ccit.dao.core.DaoFactory;
import com.ccit.page.PageDiv;

public class TestTrainUser {

	@Test
	public void testAddTrainUser() {
		TrainUserDao<TrainUser> tud = (TrainUserDao<TrainUser>) DaoFactory
				.getDao("TrainUserDao");
		TrainUser tu = new TrainUser();
		tu.setBirth(new Date());
		tu.setCardid(15);
		tu.setComment("备注");
		tu.setCustomerId(3);
		tu.setHeight(172);
		tu.setIsleader(1);
		tu.setJob("干部");
		tu.setName("老刘");
		tu.setSex("女");
		tu.setTel("18867354451");
		tu.setTrainId(1);
		try {
			tud.addTrainUser(tu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteTrainUser() {
		TrainUserDao<TrainUser> tud = (TrainUserDao<TrainUser>) DaoFactory
				.getDao("TrainUserDao");
		try {
			tud.deleteTrainUser(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateTrainUser() {
		TrainUserDao<TrainUser> tud = (TrainUserDao<TrainUser>) DaoFactory
				.getDao("TrainUserDao");
		TrainUser tu = new TrainUser();
		tu.setBirth(new Date());
		tu.setCardid(132);
		tu.setComment("备注");
		tu.setCustomerId(3);
		tu.setHeight(172);
		tu.setIsleader(1);
		tu.setJob("干部");
		tu.setName("习大大");
		tu.setSex("女");
		tu.setTel("18867354451");
		tu.setTrainId(1);
		tu.setId(5);
		try {
			tud.updateTrainUser(tu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetTrainUser() {
		TrainUserDao<TrainUser> tud = (TrainUserDao<TrainUser>) DaoFactory
				.getDao("TrainUserDao");
		try {
			TrainUser tu = tud.getTrainUser(5);
			System.out.println(tu.getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetTrainUserByTrainInfo() {
		TrainUserDao<TrainUser> tud = (TrainUserDao<TrainUser>) DaoFactory
				.getDao("TrainUserDao");
		try {
			PageDiv<TrainUser> pd = tud.getTrainUserByTrainInfo(3, 1, 1);
			System.out.println("------"+pd.getList().size());
			for (TrainUser t : pd.getList()) {
				System.out.println(t.getName());
				System.out.println("------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
