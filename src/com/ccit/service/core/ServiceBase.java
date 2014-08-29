package com.ccit.service.core;

import com.ccit.beans.Area;
import com.ccit.beans.Customer;
import com.ccit.beans.Days;
import com.ccit.beans.KeyPerson;
import com.ccit.beans.Report;
import com.ccit.beans.Staff;
import com.ccit.beans.TrainUser;
import com.ccit.beans.Visit;
import com.ccit.dao.AreaDao;
import com.ccit.dao.CustomerDao;
import com.ccit.dao.DaysDao;
import com.ccit.dao.KeyPersonDao;
import com.ccit.dao.ReportDao;
import com.ccit.dao.StaffDao;
import com.ccit.dao.TrainInfoDao;
import com.ccit.dao.TrainUserDao;
import com.ccit.dao.VisitDao;
import com.ccit.dao.core.DaoFactory;

public class ServiceBase {

	@SuppressWarnings("unchecked")
	protected AreaDao<Area> areaDao = (AreaDao<Area>) DaoFactory
			.getDao("AreaDao");

	@SuppressWarnings("unchecked")
	protected CustomerDao<Customer> customerDao = (CustomerDao<Customer>) DaoFactory
			.getDao("CustomerDao");

	@SuppressWarnings("unchecked")
	protected DaysDao<Days> daysDao = (DaysDao<Days>) DaoFactory
			.getDao("DaysDao");

	@SuppressWarnings("unchecked")
	protected KeyPersonDao<KeyPerson> keyPersonDao = (KeyPersonDao<KeyPerson>) DaoFactory
			.getDao("KeyPersonDao");

	@SuppressWarnings("unchecked")
	protected ReportDao<Report> reportDao = (ReportDao<Report>) DaoFactory
			.getDao("ReportDao");

	@SuppressWarnings("unchecked")
	protected StaffDao<Staff> staffDao = (StaffDao<Staff>) DaoFactory
			.getDao("StaffDao");

	protected TrainInfoDao trainInfoDao = (TrainInfoDao) DaoFactory
			.getDao("TrainInfoDao");

	@SuppressWarnings("unchecked")
	protected TrainUserDao<TrainUser> trainUserDao = (TrainUserDao<TrainUser>) DaoFactory
			.getDao("TrainUserDao");

	@SuppressWarnings("unchecked")
	protected VisitDao<Visit> visitDao = (VisitDao<Visit>) DaoFactory
			.getDao("VisitDao");

}
