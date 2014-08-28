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

	protected AreaDao<Area> areaDao = (AreaDao<Area>) DaoFactory
			.getDao("AreaDao");

	protected CustomerDao<Customer> customerDao = (CustomerDao<Customer>) DaoFactory
			.getDao("CustomerDao");

	protected DaysDao<Days> daysDao = (DaysDao<Days>) DaoFactory
			.getDao("DaysDao");

	protected KeyPersonDao<KeyPerson> keyPersonDao = (KeyPersonDao<KeyPerson>) DaoFactory
			.getDao("KeyPersonDao");

	protected ReportDao<Report> reportDao = (ReportDao<Report>) DaoFactory
			.getDao("ReportDao");

	protected StaffDao<Staff> staffDao = (StaffDao<Staff>) DaoFactory
			.getDao("StaffDao");

	protected TrainInfoDao trainInfoDao = (TrainInfoDao) DaoFactory
			.getDao("TrainInfoDao");

	protected TrainUserDao<TrainUser> trainUserDao = (TrainUserDao<TrainUser>) DaoFactory
			.getDao("TrainUserDao");

	protected VisitDao<Visit> visitDao = (VisitDao<Visit>) DaoFactory
			.getDao("VisitDao");

}
