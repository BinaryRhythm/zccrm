package com.ccit.dao.imp;

import java.sql.SQLException;
import java.util.List;

import com.ccit.beans.Staff;
import com.ccit.dao.StaffDao;
import com.ccit.dao.core.DaoTemplate;
import com.ccit.page.PageDiv;

public class StaffDaoImp extends DaoTemplate<Staff> implements StaffDao<Staff> {

	@Override
	public void addStaff(Staff s) {
		String sql = "insert into staff(areaID,email,pwd,name,tel,addr,limits) values(?,?,?,?,?,?,?)";
		if (null != s) {
			try {
				dao.executeUpdate(sql, s.getAreaID(), s.getEmail(), s.getPwd(),
						s.getName(), s.getTel(), s.getAddr(), s.getLimits());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("添加员工失败");
			}
		}
	}

	@Override
	public void deleteStaff(Integer id) {
		String sql = "delete from staff where id=?";
		try {
			dao.executeUpdate(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除员工失败");
		}
	}

	@Override
	public void updateStaff(Staff s) {
		String sql = "update staff set areaID=?,email=?,pwd=?,name=?,tel=?,addr=?,limits=? where id=?";
		if (null != s) {
			try {
				dao.executeUpdate(sql, s.getAreaID(), s.getEmail(), s.getPwd(),
						s.getName(), s.getTel(), s.getAddr(), s.getLimits(),
						s.getId());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("更新员工失败");
			}
		}
	}

	@Override
	public Staff getStaff(Integer id) {
		Staff staff = null;
		String sql = "select * from staff where id=?";
		try {
			staff = dao.executeQueryForBean(sql, Staff.class, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找员工失败");
		}
		return staff;
	}

	@Override
	public Staff checkLogin(String email, String pwd) throws SQLException {
		String sql = "select * from staff where email=? and pwd=?";
		return dao.executeQueryForBean(sql, Staff.class, email, pwd);
	}

	@Override
	public void addUnderStaff(Integer leaderId, Integer staffId)
			throws SQLException {
		String sql = "update staff set leaderID=? where id=?";
		dao.executeUpdate(sql, leaderId, staffId);
	}

	@Override
	public PageDiv<Staff> getAllStaff(Integer pageSize, Integer pageNo) {
		PageDiv<Staff> pd = null;
		String sql = "select * from staff limit " + ((pageNo - 1) * pageSize)
				+ "," + pageSize;
		try {
			List<Staff> list = dao.executeQuery(sql, Staff.class);
			Integer totalCount = dao
					.executeQueryForCount("select count(id) from staff");
			pd = new PageDiv<Staff>(pageSize, pageNo, totalCount, list);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询全部员工列表失败");
		}
		return pd;
	}

	@Override
	public PageDiv<Staff> getStaffByArea(Integer pageSize, Integer pageNo,
			Integer areaID) {
		PageDiv<Staff> pd = null;
		String sql = "select * from staff where areaID=?";
		try {
			List<Staff> list = dao.executeQuery(sql, Staff.class, areaID);
			Integer totalCount = dao
					.executeQueryForCount("select count(id) from staff");
			pd = new PageDiv<Staff>(pageSize, pageNo, totalCount, list);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("按区域查询员工失败");
		}

		return pd;
	}

	@Override
	public PageDiv<Staff> getStaffByleader(Integer pageSize, Integer pageNo,
			Integer leaderID) {
		PageDiv<Staff> pd = null;
		String sql = "select * from staff where leaderID=? limit ?,?";
		try {
			List<Staff> list = dao.executeQuery(sql, Staff.class, leaderID,
					(pageNo - 1) * pageSize, pageSize);
			Integer totalCount = dao
					.executeQueryForCount("select count(id) from staff");
			pd = new PageDiv<Staff>(pageSize, pageNo, totalCount, list);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("按领导查询员工失败");
		}
		return pd;
	}

}
