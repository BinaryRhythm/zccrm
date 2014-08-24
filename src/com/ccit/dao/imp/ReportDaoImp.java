package com.ccit.dao.imp;

import java.sql.SQLException;
import java.util.List;

import com.ccit.beans.Report;
import com.ccit.dao.ReportDao;
import com.ccit.dao.core.DaoTemplate;
import com.ccit.page.PageDiv;

public class ReportDaoImp extends DaoTemplate<Report> implements
		ReportDao<Report> {

	@Override
	public void addReport(Report r) throws SQLException {
		String sql = "insert into report(customerID,train_id,name,title,comment,dates,status) values(?,?,?,?,?,?,?)";
		dao.executeUpdate(sql, r.getCustomerId(), r.getTrain_id(), r.getName(),
				r.getTitile(), r.getComment(), r.getDates(), r.getStatus());
	}

	@Override
	public void deleteReport(Integer id) throws SQLException {
		String sql = "delete from report where id=" + id;
		dao.executeUpdate(sql);
	}

	@Override
	public void updateReport(Report r) throws SQLException {
		String sql = "update report set customerID=?,train_id=?,name=?,title=?,comment=?,dates=?,status=?";
		dao.executeUpdate(sql, r.getCustomerId(), r.getTrain_id(), r.getName(),
				r.getTitile(), r.getComment(), r.getDates(), r.getStatus());
	}

	@Override
	public Report getReport(Integer id) throws SQLException {
		Report r = null;
		String sql = "select * from report where id=" + id;
		r = dao.executeQueryForBean(sql, Report.class);
		return r;
	}

	@Override
	public Report getReportByCustomer(Integer customerId) throws SQLException {
		return null;
	}

	@Override
	public PageDiv<Report> getAllReport(Integer pageSize, Integer pageNo)
			throws SQLException {
		PageDiv<Report> pd = null;
		String sql = "select * from report order by id desc limit ?,?";
		List<Report> list = dao.executeQuery(sql, Report.class, (pageNo - 1),
				pageSize);
		Integer totalCount = dao
				.executeQueryForCount("select count(id) from report");
		pd = new PageDiv<Report>(pageSize, pageNo, totalCount, list);
		return pd;
	}

	@Override
	public Report getReportByStatus(Integer status) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
