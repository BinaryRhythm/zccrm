package com.ccit.dao.imp;

import java.sql.SQLException;

import com.ccit.beans.TrainUser;
import com.ccit.dao.TrainUserDao;
import com.ccit.dao.core.DaoTemplate;
import com.ccit.page.PageDiv;

public class TrainUserDaoImp extends DaoTemplate<TrainUser> implements TrainUserDao<TrainUser>{

	@Override
	public void addTrainUser(TrainUser tu) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTrainUser(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTrainUser(TrainUser tu) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getTrainUser(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PageDiv<TrainUser> getTrainUserByTrainInfo(Integer pageSize,
			Integer pageNo, Integer trainid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
