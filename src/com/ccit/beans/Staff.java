package com.ccit.beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;

import com.ccit.dao.AreaDao;
import com.ccit.dao.StaffDao;
import com.ccit.dao.core.DaoFactory;

public class Staff implements Serializable{

	/**
	 * 多添加了领导名字和地域名称
	 */
	private static final long serialVersionUID = 5412742060906540952L;

	private Integer id;
	private Integer leaderID;
	private Integer areaID;
	private String email;
	private String pwd;
	private String name;
	private String tel;
	private String addr;
	private String comments;
	private String limits;
	private Integer LoginTimes;
	private Date LoginDate;
	private Integer state;
	
	private String leaderName;
	private String areaName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLeaderID() {
		return leaderID;
	}
	public void setLeaderID(Integer leaderID) {
		this.leaderID = leaderID;
	}
	public Integer getAreaID() {
		return areaID;
	}
	public void setAreaID(Integer areaID) {
		this.areaID = areaID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getLimits() {
		return limits;
	}
	public void setLimits(String limits) {
		this.limits = limits;
	}
	public Integer getLoginTimes() {
		return LoginTimes;
	}
	public void setLoginTimes(Integer loginTimes) {
		LoginTimes = loginTimes;
	}
	public Date getLoginDate() {
		return LoginDate;
	}
	public void setLoginDate(Date loginDate) {
		LoginDate = loginDate;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getLeaderName(Integer id) {
		// 通过id获取leaderName
		String name = null;
	    StaffDao<Staff> sd = (StaffDao<Staff>) DaoFactory.getDao("StaffDao");
	    try {
			name = sd.getStaff(id).getName();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public String getAreaName(Integer id){
		String name = null;
	    AreaDao<Area> ad = (AreaDao<Area>) DaoFactory.getDao("AreaDao");
	    name = ad.getArea(id).getName();
		return name;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}	
	
}
