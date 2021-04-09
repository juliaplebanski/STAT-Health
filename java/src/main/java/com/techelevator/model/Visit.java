package com.techelevator.model;

import java.sql.Time;

import java.util.Date;

public class Visit {
	//private int visitId;
	private Date dateOfVisit;
	private Time startTime;

	private String statusId;
	private int patientId;
	private int doctorId;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

//	public int getVisitId() {
//		return visitId;
//	}
//
//	public void setVisitId(int visitId) {
//		this.visitId = visitId;
//	}

	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	

}
