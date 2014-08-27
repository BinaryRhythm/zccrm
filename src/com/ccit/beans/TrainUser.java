package com.ccit.beans;

import java.io.Serializable;
import java.util.Date;

public class TrainUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2890836923370107061L;
	/**
	 * id | int(11) customerID | int(11) train_id | int(11) name | varchar(25)
	 * sex | enum('男','女') job | varchar(25) height | int(11) cardid |
	 * varchar(25) birth | date tel | varchar(15) comment | varchar(40) isleader
	 * | int(11)
	 */

	private Integer id;
	private Integer customerId;
	private Integer trainId;
	private String name;
	private String sex;
	private String job;
	private Integer height;
	private Date birth;
	private String tel;
	private String comment;
	private Integer isleader;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getTrainId() {
		return trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getIsleader() {
		return isleader;
	}

	public void setIsleader(Integer isleader) {
		this.isleader = isleader;
	}

}
