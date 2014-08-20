package com.ccit.beans;

import java.io.Serializable;

public class Area implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2430749897898444964L;
	private Integer id;
	private String name;
	private Integer status = 0;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}	
}
