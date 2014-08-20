package com.ccit.service.core;

import com.ccit.beans.Area;
import com.ccit.dao.AreaDao;
import com.ccit.dao.core.DaoFactory;

public class ServiceBase {
	
	protected AreaDao<Area> areaDao = (AreaDao<Area>)DaoFactory.getDao("AreaDao");
}
