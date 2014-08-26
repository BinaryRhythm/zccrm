package com.ccit.beans;

import java.io.Serializable;
import java.util.Date;

public class TrainInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2020195110533679116L;

	/**
	 * id | int(11) customerID | int(11) project | varchar(25) begin | datetime
	 * end | datetime place | varchar(25) course | varchar(25) teacher |
	 * varchar(25) teachertel | varchar(25) trainer | varchar(25) trainertel |
	 * varchar(25) logistics | varchar(25) logisticstel | varchar(25) car |
	 * varchar(25) cartype | varchar(25) driver | varchar(25) drivertel |
	 * varchar(25) trainleader | varchar(25) trainleadertel | varchar(25)
	 * trainleaderbirth | varchar(25) trainercount | int(11) comment | text
	 */

	private Integer id;
	private Integer custonerId;
	private String project;
	private Date begin;
	private Date end;
	private String place;
	private String course;
	private String teacher;
	private String teachertel;
	private String trainer;
	private String trainertel;
	private String logistics;
	private String logisticstel;
	private String car;
	private String cartype;
	private String driver;
	private String drivertel;
	private String trainleader;
	private String trainleadertel;
	private String trainleaderbirth;
	private String trainercount;
	private String comment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustonerId() {
		return custonerId;
	}

	public void setCustonerId(Integer custonerId) {
		this.custonerId = custonerId;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getTeachertel() {
		return teachertel;
	}

	public void setTeachertel(String teachertel) {
		this.teachertel = teachertel;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public String getTrainertel() {
		return trainertel;
	}

	public void setTrainertel(String trainertel) {
		this.trainertel = trainertel;
	}

	public String getLogistics() {
		return logistics;
	}

	public void setLogistics(String logistics) {
		this.logistics = logistics;
	}

	public String getLogisticstel() {
		return logisticstel;
	}

	public void setLogisticstel(String logisticstel) {
		this.logisticstel = logisticstel;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getCartype() {
		return cartype;
	}

	public void setCartype(String cartype) {
		this.cartype = cartype;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getDrivertel() {
		return drivertel;
	}

	public void setDrivertel(String drivertel) {
		this.drivertel = drivertel;
	}

	public String getTrainleader() {
		return trainleader;
	}

	public void setTrainleader(String trainleader) {
		this.trainleader = trainleader;
	}

	public String getTrainleadertel() {
		return trainleadertel;
	}

	public void setTrainleadertel(String trainleadertel) {
		this.trainleadertel = trainleadertel;
	}

	public String getTrainleaderbirth() {
		return trainleaderbirth;
	}

	public void setTrainleaderbirth(String trainleaderbirth) {
		this.trainleaderbirth = trainleaderbirth;
	}

	public String getTrainercount() {
		return trainercount;
	}

	public void setTrainercount(String trainercount) {
		this.trainercount = trainercount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
