package com.ccit.service.imp;

import java.util.ArrayList;
import java.util.List;

import com.ccit.beans.Area;
import com.ccit.service.StaffService;
import com.ccit.service.core.ServiceBase;

/**
 * 
 * @author BinaryRhythm
 *
 */
public class StaffServiceImp extends ServiceBase implements StaffService {

	@Override
	public List<Area> getAllList(){
		List<Area> list = new ArrayList<Area>();
		list = areaDao.getAll();
		return list;
	}
	
}
