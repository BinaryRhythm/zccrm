package com.ccit.beans;

import java.io.Serializable;

public class Days implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4040838251389338234L;
	
	/**
	 * id StaffID days1 days2
	 */

	private Integer id;
	private Integer StaffID;
	private Integer days1;  // 生日天数
	private Integer days2;  // 周年天数
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStaffID() {
		return StaffID;
	}
	public void setStaffID(Integer staffID) {
		StaffID = staffID;
	}
	public Integer getDays1() {
		return days1;
	}
	public void setDays1(Integer days1) {
		this.days1 = days1;
	}
	public Integer getDays2() {
		return days2;
	}
	public void setDays2(Integer days2) {
		this.days2 = days2;
	}
	
	
	
}
