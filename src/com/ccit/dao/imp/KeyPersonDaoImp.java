package com.ccit.dao.imp;

import java.sql.SQLException;
import java.util.List;

import com.ccit.beans.KeyPerson;
import com.ccit.dao.KeyPersonDao;
import com.ccit.dao.core.DaoTemplate;

public class KeyPersonDaoImp extends DaoTemplate<KeyPerson> implements
		KeyPersonDao<KeyPerson> {

	@Override
	public void addKeyPerson(KeyPerson s) throws SQLException {
		String sql = "insert into keyperson(customerID,"
				+ "name,sex,age,cardid,birth,tel,job,hobby,impression) values(?,?,?,?,?,?,?,?,?,?)";
		Object[] params = { s.getCustomerID(), s.getName(), s.getSex(),
				s.getAge(), s.getCardid(), s.getBirth(), s.getTel(),
				s.getJob(), s.getHobby(), s.getImpression() };
		dao.executeUpdate(sql, params);
	}

	@Override
	public void deleteKeyPerson(Integer id) throws SQLException {
		String sql = "delete from keyperson where id=" + id;
		dao.executeUpdate(sql);
	}

	@Override
	public void updateKeyPerson(KeyPerson s) throws SQLException {
		String sql = "update keyperson set customerID=?,name=?,sex=?,age=?,cardid=?,birth=?,tel=?,job=?,hobby=?,impression=? where id=?";
		Object[] params = { s.getCustomerID(), s.getName(), s.getSex(),
				s.getAge(), s.getCardid(), s.getBirth(), s.getTel(),
				s.getJob(), s.getHobby(), s.getImpression(), s.getId() };
		dao.executeUpdate(sql, params);
	}

	@Override
	public KeyPerson getKeyPerson(Integer id) throws SQLException {
		String sql = "select * from keyperson where id=" + id;
		KeyPerson kp = dao.executeQueryForBean(sql, KeyPerson.class);
		return kp;
	}

	@Override
	public List<KeyPerson> getKeypersonByCustomer(Integer customerId)
			throws SQLException {
		List<KeyPerson> list = null;
		String sql = "select * from keyperson where customerID=" + customerId
				+ " order by id desc";
		list = dao.executeQuery(sql, KeyPerson.class);
		return list;
	}

}
