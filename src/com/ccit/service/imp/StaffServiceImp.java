package com.ccit.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ccit.beans.Area;
import com.ccit.beans.Customer;
import com.ccit.beans.Days;
import com.ccit.beans.KeyPerson;
import com.ccit.beans.Report;
import com.ccit.beans.Staff;
import com.ccit.beans.TrainInfo;
import com.ccit.beans.TrainUser;
import com.ccit.beans.Visit;
import com.ccit.dao.KeyPersonDao;
import com.ccit.page.PageDiv;
import com.ccit.service.StaffService;
import com.ccit.service.core.ServiceBase;

/**
 * 
 * @author BinaryRhythm
 *
 */
public class StaffServiceImp extends ServiceBase implements StaffService {

	private static final Logger log = Logger.getLogger(StaffService.class);

	@Override
	public List<Area> getAllArea() {
		List<Area> list = new ArrayList<Area>();
		list = areaDao.getAll();
		return list;
	}

	@Override
	public Staff checkLogin(String email, String pwd) {
		Staff staff = null;
		try {
			staff = staffDao.checkLogin(email, pwd);
			log.info("用户登录成功");
		} catch (SQLException e) {
			log.error("用户登录失败", e);
			e.printStackTrace();
		}
		return staff;
	}

	@Override
	public boolean registStaff(Staff s) {
		boolean res = false;
		try {
			staffDao.addStaff(s);
			int lastid = staffDao.getLastInsertId();
			Days days = new Days();
			days.setStaffID(lastid);
			days.setDays1(7);
			days.setDays2(7);
			daysDao.addDays(days);
			res = true;
			log.info("注册新员工成功");
		} catch (SQLException e) {
			log.error("注册新员工失败");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Staff getStaff(Integer id) {
		Staff staff = null;
		try {
			staff = staffDao.getStaff(id);
			log.info("根据员工id查询员工");
		} catch (SQLException e) {
			log.error("根据员工id查询员工失败", e);
			e.printStackTrace();
		}
		return staff;
	}

	@Override
	public boolean modifyStaffInfo(Staff staff) {
		boolean res = false;
		try {
			staffDao.updateStaff(staff);
			res = true;
			log.info("修改员工信息成功");
		} catch (SQLException e) {
			log.error("修改员工信息失败", e);
			e.printStackTrace();
		}
		return res;
	}

	// ******************* 提醒服务项

	@Override
	public Days getDaysByStaff(Integer staffId) {
		Days days = null;
		try {
			days = daysDao.getDaysByStaff(staffId);
			log.info("通过staff获取days");
		} catch (SQLException e) {
			log.error("通过staff获取days失败", e);
			e.printStackTrace();
		}
		return days;
	}

	@Override
	public boolean setAlertDays(Days days) {
		boolean res = false;
		try {
			daysDao.updateDays(days);
			log.info("设置生日提醒成功");
		} catch (SQLException e) {
			log.error("设置生日提醒失败", e);
			e.printStackTrace();
		}
		return res;
	}

	// *************** 客户操作

	@Override
	public boolean addCustomer(Customer c) {
		boolean res = false;
		try {
			customerDao.addCustomer(c);
			log.info("add customer success.");
		} catch (SQLException e) {
			log.error("add customer failed", e);
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Customer getCustomer(Integer id) {
		Customer c = null;
		try {
			customerDao.getCustomer(id);
			log.info("get customer success.");
		} catch (SQLException e) {
			log.error("get customer failed", e);
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		boolean res = false;
		try {
			customerDao.updateCustomer(c);
			log.info("update customer success");
		} catch (SQLException e) {
			log.error("update customer failed", e);
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public PageDiv<Customer> getCustomerByStaff(Integer pageSize,
			Integer pageNo, Integer staffId) {
		PageDiv<Customer> pd = null;
		try {
			pd = customerDao.getCustomerByStaff(pageSize, pageNo, staffId);
			log.info("get customer by staff success");
		} catch (SQLException e) {
			log.error("get customer by staff failed", e);
			e.printStackTrace();
		}
		return pd;
	}

	@Override
	public PageDiv<Customer> getCustomerBySubStaff(Integer pageSize,
			Integer pageNo, Integer leaderId) {
		PageDiv<Customer> pd = null;
		try {
			customerDao.getCustomerByUnderStaff(pageSize, pageNo, leaderId);
			log.info("get customr by substaff success");
		} catch (SQLException e) {
			log.error("get customer by substaff failed", e);
			e.printStackTrace();
		}
		return pd;
	}

	@Override
	public boolean addKeyPerson(KeyPerson keyPerson) {
		boolean res = false;
		try {
			keyPersonDao.addKeyPerson(keyPerson);
			res = true;
			log.info("add keyperson success");
		} catch (SQLException e) {
			log.error("add keyperson failed");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean deleteKeyPerson(Integer id) {
		boolean res = false;
		try {
			keyPersonDao.deleteKeyPerson(id);
			res = true;
			log.info("delete a keyprson");
		} catch (SQLException e) {
			log.error("delete keyperson failed", e);
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean updateKeyPerson(KeyPerson kp) {
		boolean res = false;
		try {
			keyPersonDao.updateKeyPerson(kp);
			res = true;
			log.info("update keyperson success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public KeyPerson getKeyPerson(Integer id) {
		KeyPerson kp = null;
		try {
			kp = keyPersonDao.getKeyPerson(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kp;
	}

	// 可以通过PageDiv进行分页
	@Override
	public List<KeyPerson> getKeyPersonByCustomer(Integer customerId) {
		List<KeyPerson> kp = null;
		try {
			kp = keyPersonDao.getKeypersonByCustomer(customerId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kp;
	}

	@Override
	public boolean addVisit(Visit v) {
		boolean res = false;
		try {
			visitDao.addVisit(v);
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean deleteVisit(Integer id) {
		boolean res = false;
		try {
			visitDao.deleteVisit(id);
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean updateVisit(Visit v) {
		boolean res = false;
		try {
			visitDao.updateVisit(v);
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Visit getVisit(Integer id) {
		Visit v = null;
		try {
			v = visitDao.getVisit(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return v;
	}

	@Override
	public List<Visit> getVisitByCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageDiv<Visit> getVisitByCustomer(Integer pageSize, Integer pageNo,
			Integer customerId) {
		PageDiv<Visit> pd = null;
		try {
			pd = visitDao.getVisitByCustomer(pageSize, pageNo, customerId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pd;

	}

	@Override
	public boolean addTrainInfo(TrainInfo ti) {
		boolean res = false;
		try {
			trainInfoDao.addTrainInfo(ti);
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean deleteTrainInfo(Integer id) {
		boolean res = false;
		try {
			trainInfoDao.deleteTrainInfo(id);
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean updateTrainInfo(TrainInfo trainInfo) {
		boolean res = false;
		try {
			trainInfoDao.updateTrainInfo(trainInfo);
			res = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public TrainInfo getTrainInto(Integer id) {
		TrainInfo ti = null;
		try {
			ti = trainInfoDao.getTrainInfo(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ti;
	}

	@Override
	public List<TrainInfo> getTrainInfoByCustomer(Integer customerId) {

		return null;
	}

	@Override
	public PageDiv<TrainInfo> getTrainInfoByCustomer(Integer pageSize,
			Integer pageNo, Integer customerId) {
		PageDiv<TrainInfo> pd = null;
		try {
			pd = trainInfoDao.getTrainInfoByCustomer(pageSize, pageNo,
					customerId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pd;
	}

	@Override
	public boolean addTrainUser(TrainUser tu) {
		boolean res = false;
		try {
			trainUserDao.addTrainUser(tu);
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean deleteTrainUser(Integer id) {
		boolean res = false;
		try {
			trainUserDao.deleteTrainUser(id);
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean updateTrainUser(TrainUser tu) {
		boolean res = false;
		try {
			trainUserDao.updateTrainUser(tu);
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public TrainUser getTrainUser(Integer id) {
		TrainUser tu = null;
		try {
			tu = trainUserDao.getTrainUser(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tu;
	}

	@Override
	public PageDiv<TrainUser> getTrainUserByTrainInfo(Integer pageSize,
			Integer pageNo, Integer trainInfoId) {
		PageDiv<TrainUser> pd = null;
		try {
			pd = trainUserDao.getTrainUserByTrainInfo(pageSize, pageNo,
					trainInfoId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pd;
	}

	@Override
	public boolean addReport(Report r) {
		boolean res = false;
		try {
			reportDao.addReport(r);
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean deleteReport(Integer id) {
		boolean res = false;
		try {
			reportDao.deleteReport(id);
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean updateReport(Report r) {
		boolean res = false;
		try {
			reportDao.updateReport(r);
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Report getReport(Integer id) {
		Report r = null;
		try {
			r = reportDao.getReport(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public PageDiv<Report> getAllReport(Integer pageSize, Integer pageNo) {
		PageDiv<Report> pd = null;
		try {
			pd = reportDao.getAllReport(pageSize, pageNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pd;
	}

	@Override
	public PageDiv<Report> getReportByStatus(Integer pageSize, Integer pageNo,
			Integer statusId) {
		PageDiv<Report> pd = null;
		try {
			pd = reportDao.getReportByStatus(pageSize, pageNo, statusId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pd;
	}

	@Override
	public Integer getIdByName(String leaderName) {
		Integer id = 0;
		try {
			id = staffDao.getIdByName(leaderName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

}
