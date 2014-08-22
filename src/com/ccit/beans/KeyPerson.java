package com.ccit.beans;

import java.io.Serializable;
import java.util.Date;

public class KeyPerson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3315385300924805666L;

	/**
	 * id | int(11) customerID | int(11) name | varchar(25) sex | enum('男','女')
	 * age | int(3) cardid | varchar(25) birth | date tel | varchar(15) job |
	 * varchar(25) hobby | varchar(45) impression | varchar(140)
	 */

	private Integer id;
	private Integer customerID;
	private String name;
	private String sex;
	private Integer age;
	private String cardid;
	private Date birth;
	private String tel;
	private String job;
	private String hobby;
	private String impression;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getImpression() {
		return impression;
	}
	public void setImpression(String impression) {
		this.impression = impression;
	}
	
	
	
}
