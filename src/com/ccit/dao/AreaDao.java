package com.ccit.dao;

import java.util.List;

public interface AreaDao<Area> {

	public void addArea(Area a);
	public void deleteArea(Integer id);
	public void updateArea(Area area);
	public Area getArea(Integer id);
	
	public List<Area> getAll();
	
}
