package com.ccit.dao.imp;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ccit.beans.Customer;
import com.ccit.dao.CustomerDao;
import com.ccit.dao.core.DaoTemplate;
import com.ccit.page.PageDiv;

public class CustomerDaoImp extends DaoTemplate<Customer> implements
		CustomerDao<Customer> {

	@Override
	public void addCustomer(Customer c) throws SQLException {
		String sql = "insert into customer "
				+ "(staffID,areaID,customerno,name,"
				+ "legal,service,dimension,website,email,"
				+ "tel,address,comment,createdate,createtype,birth) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		Object[] params = customerToParamsArray(c,0);
		dao.executeUpdate(sql, params);
	}

	@Override
	public void deleteCustomer(Integer id) throws SQLException {
		String sql = "delete from customer where id=" + id;
		dao.executeUpdate(sql);
	}

	@Override
	public void updateCustomer(Customer c) throws SQLException {
		String sql = "update customer set staffID=?,areaID=?,customerno=?,name=?,"
				+ "legal=?,service=?,dimension=?,website=?,email=?,"
				+ "tel=?,address=?,comment=?,createdate=?,createtype=?,birth=? where id=?";
		Object[] params = customerToParamsArray(c, 1);
		dao.executeUpdate(sql, params);
	}

	@Override
	public Customer getCustomer(Integer id) throws SQLException {
		String sql = "select * from customer where id=" + id;
		Customer c = dao.executeQueryForBean(sql, Customer.class);
		return c;
	}

	@Override
	public PageDiv<Customer> getAllCustomer(Integer pageSize, Integer pageNo)
			throws SQLException {
		PageDiv<Customer> pd = null;
		String sql = "select * from customer limit "
				+ ((pageNo - 1) * pageSize) + "," + pageSize;
		List<Customer> list = dao.executeQuery(sql, Customer.class);
		Integer totalCount = dao
				.executeQueryForCount("select count(id) from customer");
		pd = new PageDiv<Customer>(pageSize, pageNo, totalCount, list);
		return pd;
	}

	@Override
	public PageDiv<Customer> getCustomerByStaff(Integer pageSize,
			Integer pageNo, Integer staffId) throws SQLException {
		PageDiv<Customer> pd = null;
		String sql = "select * from customer where staffID=" + staffId + " limit "
				+ ((pageNo - 1) * pageSize) + "," + pageSize;
		List<Customer> list = dao.executeQuery(sql, Customer.class);
		Integer totalCount = dao
				.executeQueryForCount("select count(id) from customer");
		pd = new PageDiv<Customer>(pageSize, pageNo, totalCount, list);
		return pd;
	}

	@Override
	public PageDiv<Customer> getCustomerByArea(Integer pageSize,
			Integer pageNo, Integer areaId) throws SQLException {
		PageDiv<Customer> pd = null;
		String sql = "select * from customer where areaID=" + areaId + " limit "
				+ ((pageNo - 1) * pageSize) + "," + pageSize;
		List<Customer> list = dao.executeQuery(sql, Customer.class);
		Integer totalCount = dao
				.executeQueryForCount("select count(id) from customer");
		pd = new PageDiv<Customer>(pageSize, pageNo, totalCount, list);
		return pd;
	}

	/**
	 * 通过员工id和区域id查找客户
	 */
	@Override
	public PageDiv<Customer> getCustomerByStaffAndArea(Integer pageSize,
			Integer pageNo, Integer staffId, Integer areaId)
			throws SQLException {
		PageDiv<Customer> pd = null;
		String sql = "select * from customer where staffID=? and areaID=?" + " limit "
				+ ((pageNo - 1) * pageSize) + "," + pageSize;
		List<Customer> list = dao.executeQuery(sql, Customer.class, staffId,
				areaId);
		Integer totalCount = dao
				.executeQueryForCount("select count(id) from customer");
		pd = new PageDiv<Customer>(pageSize, pageNo, totalCount, list);
		return pd;
	}

	/**
	 * 通过下属员工获取客户
	 */
	@Override
	public PageDiv<Customer> getCustomerByUnderStaff(Integer pageSize,
			Integer pageNo, Integer leaderId) throws SQLException {
		PageDiv<Customer> pd = null;
		
		String sql = "select * from customer where staffID in(select id from staff where leaderID=?) order by id desc limit ?,?";
		
//		 "select * customer where staffID in(select id from staff where leaderID=?) order by id desc limit 0,1";
		List<Customer> list = dao.executeQuery(sql, Customer.class, leaderId,
				(pageNo-1)*pageSize,pageSize);
		String sqlAll = "select * from customer where staffID in(select id from staff where leaderID="
				+ leaderId + ")";
		Integer totalCount = dao.executeQueryForCount(sqlAll);
		pd = new PageDiv<Customer>(pageSize, pageNo, totalCount, list);
		return pd;
	}

	/**
	 * 把customer对象转换成对象数组， 数组中对象的顺序同数据库
	 * 
	 * @param c
	 *            Customer对象实例
	 * @return
	 */
	private Object[] customerToParamsArray(Customer c, int flag) {
		Object[] obj = null;
		switch (flag) {
		case 0:
			// 修改时间为创建时间
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			c.setCreatedate(sdf.format(date.getTime()));

			obj = new Object[] { c.getStaffID(), c.getAreaID(),
					c.getCustomerno(), c.getName(), c.getLegal(),
					c.getService(), c.getDimension(), c.getWebsite(),
					c.getEmail(), c.getTel(), c.getAddress(), c.getComment(),
					c.getCreatedate(), c.getCreatetype(), c.getBirth() };
			break;
		case 1:
			obj = new Object[] { c.getStaffID(), c.getAreaID(),
					c.getCustomerno(), c.getName(), c.getLegal(),
					c.getService(), c.getDimension(), c.getWebsite(),
					c.getEmail(), c.getTel(), c.getAddress(), c.getComment(),
					c.getCreatedate(), c.getCreatetype(), c.getBirth(),c.getId()};
			c.getId();
			break;
		default:
			break;
		}

		return obj;
	}

}
