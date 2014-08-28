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
	public List<Area> getAllArea(){
		List<Area> list = new ArrayList<Area>();
		list = areaDao.getAll();
		return list;
	}

	@Override
	public Staff checkLogin(String email, String pwd) {
		Staff staff = null;
		try{
			staff = staffDao.checkLogin(email,pwd);
			log.info("用户登录成功");
		}catch(SQLException e){
			log.error("用户登录失败",e);
			e.printStackTrace();
		}
		return staff;
	}

	@Override
	public boolean registStaff(Staff s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Staff getStaff(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyStaffInfo(Staff staff) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Days getDays(Integer staffId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setAlertDays(Days days) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCustomer(Customer c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getCustomer(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PageDiv<Customer> getCustomerByStaff(Integer pageSize,
			Integer pageNo, Integer staffId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageDiv<Customer> getCustomerBySubStaff(Integer pageSize,
			Integer pageNo, Integer leaderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addKeyPerson(KeyPerson keyPerson) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteKeyPerson(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateKeyPerson(KeyPerson kp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public KeyPerson getKeyPerson(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KeyPerson> getKeyPersonByCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addVisit(Visit v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteVisit(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateVisit(Visit v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Visit getVisit(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Visit> getVisitByCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageDiv<Visit> getVisitByCustomer(Integer pageSize, Integer pageNo,
			Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addTrainInfo(TrainInfo trainInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTrainInfo(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTrainInfo(TrainInfo trainInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TrainInfo getTrainInto(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TrainInfo> getTrainInfoByCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageDiv<TrainInfo> getTrainInfoByCustomer(Integer pageSize,
			Integer pageNo, Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addTrainUser(TrainUser tu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTrainUser(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTrainUser(TrainUser tu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TrainUser getTrainUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageDiv<TrainUser> getTrainUserByTrainInfo(Integer pageSize,
			Integer pageNo, Integer trainInfoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addReport(Report r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteReport(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateReport(Report r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Report getReport(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageDiv<Report> getAllReport(Integer pageSize, Integer pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageDiv<Report> getReportByStatus(Integer pageSize, Integer pageNo,
			Integer statusId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
