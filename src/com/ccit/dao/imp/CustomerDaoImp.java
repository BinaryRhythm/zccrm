package com.ccit.dao.imp;

import java.sql.SQLException;
import java.util.List;

import com.ccit.beans.Customer;
import com.ccit.beans.Staff;
import com.ccit.dao.CustomerDao;
import com.ccit.dao.core.DaoTemplate;
import com.ccit.page.PageDiv;

public class CustomerDaoImp extends DaoTemplate<Customer> implements
		CustomerDao<Customer> {

	@Override
	public void addCustomer(Customer c) throws SQLException {
		String sql = "inset into customer "
				+ "(staffID,areaID,customerno,name,"
				+ "legal,service,dimension,website,email,"
				+ "tel,address,comment,createdate,createtype,birth) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		Object[] params = customerToParamsArray(c);
		dao.executeQuery(sql, Customer.class, params);
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
		Object[] params = customerToParamsArray(c);
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
			Integer pageNo, Staff staffId) throws SQLException {
		PageDiv<Customer> pd = null;
		String sql = "select * from customer where staffID=" + staffId;
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
		String sql = "select * from customer where areaID=" + areaId;
		List<Customer> list = dao.executeQuery(sql, Customer.class);
		Integer totalCount = dao
				.executeQueryForCount("select count(id) from customer");
		pd = new PageDiv<Customer>(pageSize, pageNo, totalCount, list);
		return pd;
	}

	@Override
	public PageDiv<Customer> getCustomerByStaffAndArea(Integer pageSize,
			Integer pageNo, Integer staffId, Integer areaId)
			throws SQLException {
		PageDiv<Customer> pd = null;
		String sql = "select * from customer where staffID=? and areaID=?";
		List<Customer> list = dao.executeQuery(sql, Customer.class,staffId,areaId);
		Integer totalCount = dao
				.executeQueryForCount("select count(id) from customer");
		pd = new PageDiv<Customer>(pageSize, pageNo, totalCount, list);
		return pd;
	}

	@Override
	public PageDiv<Customer> getCustomerByUnderStaff(Integer pageSize,
			Integer pageNo, Integer leaderId) throws SQLException {
		PageDiv<Customer> pd = null;
		String sql = "";
		return null;
	}

	/**
	 * 把customer对象转换成对象数组， 数组中对象的顺序同数据库
	 * 
	 * @param c
	 *            Customer对象实例
	 * @return
	 */
	private Object[] customerToParamsArray(Customer c) {
		Object[] obj = null;
		obj = new Object[] { c.getStaffID(), c.getAreaID(), c.getCustomerno(),
				c.getName(), c.getLegal(), c.getService(), c.getDimension(),
				c.getWebsite(), c.getEmail(), c.getTel(), c.getAddress(),
				c.getComment(), c.getCreatedate(), c.getCreatetype(),
				c.getBirth() };
		return obj;
	}

}
