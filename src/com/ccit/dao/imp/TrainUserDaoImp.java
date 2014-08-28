package com.ccit.dao.imp;

import java.sql.SQLException;
import java.util.List;

import com.ccit.beans.TrainUser;
import com.ccit.dao.TrainUserDao;
import com.ccit.dao.core.DaoTemplate;
import com.ccit.page.PageDiv;

public class TrainUserDaoImp extends DaoTemplate<TrainUser> implements
		TrainUserDao<TrainUser> {

	@Override
	public void addTrainUser(TrainUser tu) throws SQLException {
		String sql = "insert into trainuser(customerID,train_id,name,sex,job,"
				+ "height,cardid,birth,tel,comment,isleader) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		dao.executeUpdate(sql, tu.getCustomerId(), tu.getTrainId(),
				tu.getName(), tu.getSex(), tu.getJob(), tu.getHeight(),
				tu.getCardid(), tu.getBirth(), tu.getTel(), tu.getComment(),
				tu.getIsleader());

	}

	@Override
	public void deleteTrainUser(Integer id) throws SQLException {
		String sql = "delete from trainuser where id=" + id;
		dao.executeUpdate(sql);

	}

	@Override
	public void updateTrainUser(TrainUser tu) throws SQLException {
		String sql = "update trainuser set customerID=?,train_id=?,name=?,sex=?,job=?,"
				+ "height=?,cardid=?,birth=?,tel=?,comment=?,isleader=? where id=?";
		dao.executeUpdate(sql, tu.getCustomerId(), tu.getTrainId(),
				tu.getName(), tu.getSex(), tu.getJob(), tu.getHeight(),
				tu.getCardid(), tu.getBirth(), tu.getTel(), tu.getComment(),
				tu.getIsleader(), tu.getId());
	}

	@Override
	public TrainUser getTrainUser(Integer id) throws SQLException {
		TrainUser tu = null;
		String sql = "select * from trainuser where id=" + id;
		tu = dao.executeQueryForBean(sql, TrainUser.class);
		return tu;
	}

	@Override
	public PageDiv<TrainUser> getTrainUserByTrainInfo(Integer pageSize,
			Integer pageNo, Integer trainid) throws SQLException {
		PageDiv<TrainUser> pd = null;
		String sql = "select * from trainuser where train_id=? order by id desc limit ?,?";
		List<TrainUser> list = dao.executeQuery(sql, TrainUser.class, trainid,
				pageNo - 1, pageSize);
		Integer totalCount = dao
				.executeQueryForCount("select count(id) from trainuser");
		pd = new PageDiv<TrainUser>(pageSize, pageNo, totalCount, list);
		return pd;
	}

}
