package com.ccit.beans;

import java.io.Serializable;
import java.util.Date;

public class Report implements Serializable {

	/*
	 * id | int(11) customerID | int(11) train_id | int(11) name | varchar(25)
	 * title | varchar(45) comment | text dates | date status | int(1)
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = -2222771933581627508L;
	private Integer id;
	private Integer customerId;
	private Integer train_id;
	private String name;
	private String titile;
	private String comment;
	private Date dates;
	private Integer status;

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

	public Integer getTrain_id() {
		return train_id;
	}

	public void setTrain_id(Integer train_id) {
		this.train_id = train_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitile() {
		return titile;
	}

	public void setTitile(String titile) {
		this.titile = titile;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDates() {
		return dates;
	}

	public void setDates(Date dates) {
		this.dates = dates;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
