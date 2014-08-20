package com.ccit.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ccit.beans.Area;
import com.ccit.dao.AreaDao;
import com.ccit.dao.core.DaoTemplate;

public class AreaDaoImp extends DaoTemplate<Area> implements AreaDao<Area> {

	@Override
	public void addArea(Area a) {
		String sql = "insert into area(name,status) values(?,?)";
		if (null != a) {
			try {
				dao.executeUpdate(sql, a.getName(), a.getStatus());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("添加区域失败");
			}
		}
	}

	@Override
	public void deleteArea(Integer id) {
		String sql = "delete from area where id=?";
		try {
			dao.executeUpdate(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除区域异常");
		}
	}

	@Override
	public void updateArea(Area area) {
		String sql = "update area set name=?,status=? where id=?";
		if (null != area) {
			try {
				dao.executeUpdate(sql, area.getName(), area.getStatus(),
						area.getId());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("更新区域异常");
			}
		}
	}

	@Override
	public Area getArea(Integer id) {
		Area area = null;
		String sql = "select * from area where id=" + id;
		try {
			area = dao.executeQueryForBean(sql, Area.class);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找区域对象异常");
		}
		return area;
	}

	@Override
	public List<Area> getAll() {
		List<Area> list = new ArrayList<Area>();
		String sql = "select * from area";
		try {
			list = dao.executeQuery(sql, Area.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询所有区域异常");
		}
		return list;
	}

}
