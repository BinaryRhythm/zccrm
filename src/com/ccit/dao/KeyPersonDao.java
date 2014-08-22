package com.ccit.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface KeyPersonDao<KeyPerson extends Serializable>{

	public void addKeyPerson(KeyPerson s) throws SQLException;
	public void deleteKeyPerson(Integer id) throws SQLException;
	public void updateKeyPerson(KeyPerson s) throws SQLException;
	public KeyPerson getKeyPerson(Integer id) throws SQLException;
	
	/**
	 * 通过customer id查找keyperson
	 * @param keyPersonId
	 * @return
	 * @throws SQLException
	 */
	public List<KeyPerson> getKeypersonByCustomer(Integer customerId) throws SQLException;
	
	
	
}
