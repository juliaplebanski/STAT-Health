package com.techelevator.model;

import java.sql.Time;
import java.time.LocalDate;


public class Visit {
	//private int visitId;
	private LocalDate dateOfVisit;
	private Time startTime;
	private String statusId;
	private int patientId;
	private int doctorId;
	private String doctorFirstName;
	private String doctorLastName;
	private String visitReason;
	private String description;
	
	public String getVisitReason() {
		return visitReason;
	}

	public void setVisitReason(String visitReason) {
		this.visitReason = visitReason;
	}


	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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

	public LocalDate getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(LocalDate dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public String getDoctorFirstName() {
		return doctorFirstName;
	}

	public void setDoctorFirstName(String doctorFirstName) {
		this.doctorFirstName = doctorFirstName;
	}

	public String getDoctorLastName() {
		return doctorLastName;
	}

	public void setDoctorLastName(String doctorLastName) {
		this.doctorLastName = doctorLastName;
	}

	

}