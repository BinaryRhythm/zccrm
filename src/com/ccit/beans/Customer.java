package com.ccit.beans;

import java.io.Serializable;

public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8687900228384182923L;

	/*
	 * id staffID areaID customerno name legal service dimension website email
	 * tel address comment createdate createtype birth
	 */

	private Integer staffID;
	private Integer areaID;
	private String customerno;
	private String name;
	private String legal;
	private String service;
	private String dimension;
	private String website;
	private String email;
	private String tel;
	private String address;
	private String comment;
	private String createdate;
	private String createtype;
	private String birth;

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getCreatetype() {
		return createtype;
	}

	public void setCreatetype(String createtype) {
		this.createtype = createtype;
	}

	public Integer getStaffID() {
		return staffID;
	}

	public void setStaffID(Integer staffID) {
		this.staffID = staffID;
	}

	public Integer getAreaID() {
		return areaID;
	}

	public void setAreaID(Integer areaID) {
		this.areaID = areaID;
	}

	public String getCustomerno() {
		return customerno;
	}

	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLegal() {
		return legal;
	}

	public void setLegal(String legal) {
		this.legal = legal;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

}
