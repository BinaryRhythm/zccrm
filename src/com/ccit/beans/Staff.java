package com.ccit.beans;

import java.io.Serializable;
import java.util.Date;

public class Staff implements Serializable{

	/**
	 * 
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
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}	
	
}
