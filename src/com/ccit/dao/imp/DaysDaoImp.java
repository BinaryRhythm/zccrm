package com.ccit.dao.imp;

import java.sql.SQLException;

import com.ccit.beans.Days;
import com.ccit.dao.DaysDao;
import com.ccit.dao.core.DaoTemplate;

public class DaysDaoImp extends DaoTemplate<Days> implements DaysDao<Days>{

	@Override
	public void addDays(Days d) throws SQLException {
		String sql = "insert into days(StaffID,days1,days2) values(?,?,?)";
		dao.executeUpdate(sql, d.getStaffID(),d.getDays1(),d.getDays2());
	}

	@Override
	public void deleteDays(Integer id) throws SQLException {
		String sql = "delete from days where id="+id;
		dao.executeUpdate(sql);
	}

	@Override
	public void updateDays(Days d) throws SQLException {
          String sql = "update days set staffID=?,days1=?,days2=? where id=?";	
          dao.executeUpdate(sql, d.getStaffID(),d.getDays1(),d.getDays2(),d.getId());
	}

	@Override
	public Days getDays(Integer id) throws SQLException {
		Days day;
		String sql = "select * from days where id="+id;
		day = dao.executeQueryForBean(sql, Days.class);
		return day;
	}

	@Override
	public Days getDaysByStaff(Integer id) throws SQLException {
		String sql = "select * from days where id=" + id;
		return dao.executeQueryForBean(sql, Days.class);
	}

}
