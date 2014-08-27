package com.ccit.dao.imp;

import java.sql.SQLException;
import java.util.List;

import com.ccit.beans.TrainInfo;
import com.ccit.dao.TrainInfoDao;
import com.ccit.dao.core.DaoTemplate;
import com.ccit.page.PageDiv;

public class TrainInfoDaoImp extends DaoTemplate<TrainInfo> implements
		TrainInfoDao<TrainInfo> {

	@Override
	public void addTrainInfo(TrainInfo ti) throws SQLException {
		String sql = "insert into traininfo" + "(customerID,project,begin,end,"
				+ "place,course,teacher,teachertel,"
				+ "trainer,trainertel,logistics,"
				+ "logisticstel,car,cartype,driver,"
				+ "drivertel,trainleader,trainleadertel,"
				+ "trainleaderbirth,trainercount,comment) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		// 21 个参数
		Object[] params = { ti.getCustomerId(), ti.getProject(), ti.getBegin(),
				ti.getEnd(), ti.getPlace(), ti.getCourse(), ti.getTeacher(),
				ti.getTeachertel(), ti.getTrainer(), ti.getTrainertel(),
				ti.getLogistics(), ti.getLogisticstel(), ti.getCar(),
				ti.getCartype(), ti.getDriver(), ti.getDrivertel(),
				ti.getTrainleader(), ti.getTrainleadertel(),
				ti.getTrainleaderbirth(), ti.getTrainercount(), ti.getComment() };
		dao.executeUpdate(sql, params);
	}

	@Override
	public void deleteTrainInfo(Integer id) throws SQLException {
		String sql = "delete from traininfo where id=" + id;
		dao.executeUpdate(sql);

	}

	@Override
	public void updateTrainInfo(TrainInfo ti) throws SQLException {
		String sql = "update traininfo set customerID=?,project=?,begin=?,end=?,"
				+ "place=?,course=?,teacher=?,teachertel=?,"
				+ "trainer=?,trainertel=?,logistics=?,"
				+ "logisticstel=?,car=?,cartype=?,driver=?,"
				+ "drivertel=?,trainleader=?,trainleadertel=?,"
				+ "trainleaderbirth=?,trainercount=?,comment=? where id=?";

		Object[] params = { ti.getCustomerId(), ti.getProject(), ti.getBegin(),
				ti.getEnd(), ti.getPlace(), ti.getCourse(), ti.getTeacher(),
				ti.getTeachertel(), ti.getTrainer(), ti.getTrainertel(),
				ti.getLogistics(), ti.getLogisticstel(), ti.getCar(),
				ti.getCartype(), ti.getDriver(), ti.getDrivertel(),
				ti.getTrainleader(), ti.getTrainleadertel(),
				ti.getTrainleaderbirth(), ti.getTrainercount(),
				ti.getComment(), ti.getId() };
		dao.executeUpdate(sql, params);
	}

	@Override
	public TrainInfo getTrainInfo(Integer id) throws SQLException {
		return dao.executeQueryForBean(
				"select * from traininfo where id=" + id, TrainInfo.class);
	}

	@Override
	public PageDiv<TrainInfo> getAllTrainInfo(Integer pageSize, Integer pageNo)
			throws SQLException {
		PageDiv<TrainInfo> pd = null;
		String sql = "select * from traininfo order by id desc limit ?,?";
		List<TrainInfo> list = dao.executeQuery(sql, TrainInfo.class,
				pageNo - 1, pageSize);
		Integer totalCount = dao
				.executeQueryForCount("select count(id) from traininfo");
		pd = new PageDiv<TrainInfo>(pageSize, pageNo, totalCount, list);
		return pd;
	}

	@Override
	public PageDiv<TrainInfo> getTrainInfoByCustomer(Integer pageSize,
			Integer pageNo, Integer customerId) throws SQLException {
		PageDiv<TrainInfo> pd = null;
		String sql = "select * from traininfo where customerID=? order by id desc limit ?,?";
		List<TrainInfo> list = dao.executeQuery(sql, TrainInfo.class,
				customerId, pageNo - 1, pageSize);
		Integer totalCount = dao
				.executeQueryForCount("select count(id) from traininfo");
		pd = new PageDiv<TrainInfo>(pageSize, pageNo, totalCount, list);
		return pd;
	}

}
