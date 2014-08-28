package com.ccit.dao;

import java.io.Serializable;
import java.sql.SQLException;

import com.ccit.page.PageDiv;

public interface TrainUserDao<TrainUser extends Serializable> {

	public void addTrainUser(TrainUser tu) throws SQLException;

	public void deleteTrainUser(Integer id) throws SQLException;

	public void updateTrainUser(TrainUser tu) throws SQLException;

	public TrainUser getTrainUser(Integer id) throws SQLException;

	/**
	 * 通过tainInfo id获取user
	 * @param pageSize
	 * @param pageNo
	 * @param trainid
	 * @return
	 * @throws SQLException
	 */
	public PageDiv<TrainUser> getTrainUserByTrainInfo(Integer pageSize,Integer pageNo,Integer trainid)
			throws SQLException;
	

	
	
}
