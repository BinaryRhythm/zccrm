package com.ccit.beans;

import java.io.Serializable;
import java.util.Date;

public class Visit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5363136931249723819L;

	/**
	 * id | int(11) customerID | int(11) jdr | varchar(25) jqr | varchar(25)
	 * record | varchar(25) comment | text dates | date
	 */

	private Integer id;
	private Integer customerId;
	private String jdr; // 接待人
	private String jqr; // 接洽人
	private String record;
	private String comment;
	private Date dates;
	
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
	public String getJdr() {
		return jdr;
	}
	public void setJdr(String jdr) {
		this.jdr = jdr;
	}
	public String getJqr() {
		return jqr;
	}
	public void setJqr(String jqr) {
		this.jqr = jqr;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
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
	
	

}
