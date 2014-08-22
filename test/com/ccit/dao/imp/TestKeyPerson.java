package com.ccit.dao.imp;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.ccit.beans.KeyPerson;
import com.ccit.dao.KeyPersonDao;
import com.ccit.dao.core.DaoFactory;

public class TestKeyPerson {

	@Test
	public void testAddKeyperson() {
		KeyPersonDao<KeyPerson> kpd = (KeyPersonDao<KeyPerson>) DaoFactory
				.getDao("KeyPersonDao");
		KeyPerson kp = new KeyPerson();
		kp.setAge(31);
		kp.setBirth(new Date());
		kp.setCardid("009");
		kp.setCustomerID(7);
		kp.setHobby("巴乌");
		kp.setImpression("品德高尚");
		kp.setJob("档案整理");
		kp.setName("琳达");
		kp.setSex("男");
		kp.setTel("1886735881");
		try {
			kpd.addKeyPerson(kp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteKeyperson() {
		KeyPersonDao<KeyPerson> kpd = (KeyPersonDao<KeyPerson>) DaoFactory
				.getDao("KeyPersonDao");
		try {
			kpd.deleteKeyPerson(4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateKeyperson() {
		KeyPersonDao<KeyPerson> kpd = (KeyPersonDao<KeyPerson>) DaoFactory
				.getDao("KeyPersonDao");
		KeyPerson kp = new KeyPerson();
		kp.setAge(31);
		kp.setBirth(new Date());
		kp.setCardid("004");
		kp.setCustomerID(7);
		kp.setHobby("巴乌");
		kp.setImpression("品德高尚");
		kp.setJob("为人民服务");
		kp.setName("琳达");
		kp.setSex("男");
		kp.setTel("1886735881");
		kp.setId(5);
		try {
			kpd.updateKeyPerson(kp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetKeyperson(){
		KeyPersonDao<KeyPerson> kpd = (KeyPersonDao<KeyPerson>)DaoFactory.getDao("KeyPersonDao");
		try {
			KeyPerson kp = kpd.getKeyPerson(2);
			System.out.println(kp.getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testGetKeypersonByCustomer(){
		KeyPersonDao<KeyPerson> kpd = (KeyPersonDao<KeyPerson>)DaoFactory.getDao("KeyPersonDao");
        try {
			List<KeyPerson> l = kpd.getKeypersonByCustomer(6);
			for(KeyPerson p:l){
				System.out.println(p.getName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
