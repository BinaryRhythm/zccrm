package com.ccit.dao;

import java.sql.SQLException;

import com.ccit.beans.TrainInfo;
import com.ccit.page.PageDiv;

public interface TrainInfoDao {

	public void addTrainInfo(TrainInfo ti) throws SQLException;

	public void deleteTrainInfo(Integer id) throws SQLException;

	public void updateTrainInfo(TrainInfo ti) throws SQLException;

	public TrainInfo getTrainInfo(Integer id) throws SQLException;

	public PageDiv<TrainInfo> getAllTrainInfo(Integer pageSize, Integer pageNo)
			throws SQLException;

	public PageDiv<TrainInfo> getTrainInfoByCustomer(Integer pageSize,
			Integer pageNo, Integer customerId) throws SQLException;
}
