package com.ccit.dao.imp;

import java.sql.SQLException;
import java.util.List;

import com.ccit.beans.Visit;
import com.ccit.dao.Dao;
import com.ccit.dao.VisitDao;
import com.ccit.dao.core.DaoTemplate;
import com.ccit.page.PageDiv;

public class VisitDaoImp extends DaoTemplate<Visit> implements VisitDao<Visit>,
		Dao<Visit> {

	@Override
	public void add(Visit t) throws SQLException {
		String sql = "insert into visit(customerID,jdr,jqr,record,comment,dates) values(?,?,?,?,?,?)";
		dao.executeUpdate(sql, t.getCustomerId(), t.getJdr(), t.getJqr(),
				t.getRecord(), t.getComment(), t.getDates());
	}

	@Override
	public void delete(Integer id) throws SQLException {
		String sql = "delete from visit where id=" + id;
		dao.executeUpdate(sql);
	}

	@Override
	public void update(Visit t) throws SQLException {
		String sql = "update visit set customerID=?,jdr=?,jqr=?,comment=?,dates=? where id=?";
		dao.executeUpdate(sql,t.getCustomerId(), t.getJdr(), t.getJqr(),
				t.getComment(), t.getDates(), t.getId());
	}

	@Override
	public Visit get(Integer id) throws SQLException {
		Visit v = null;
		String sql = "select * from visit where id=" + id;
		v = dao.executeQueryForBean(sql, Visit.class);
		return v;
	}

	@Override
	public PageDiv<Visit> getVisitByCustomer(Integer pageSize, Integer pageNo,
			Integer id) throws SQLException {
		PageDiv<Visit> pd = null;
		String sql = "select * from visit where customerID=? order by id desc limit ?,?";
		List<Visit> list = dao.executeQuery(sql, Visit.class, id, pageNo - 1,
				pageSize);
		Integer totalCount = dao
				.executeQueryForCount("select count(id) from visit");
		pd = new PageDiv<Visit>(pageSize, pageNo, totalCount, list);
		return pd;
	}

}
