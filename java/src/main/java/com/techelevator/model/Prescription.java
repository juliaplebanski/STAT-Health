package com.techelevator.model;

public class Prescription {

	
	private String prescriptionName;
	private int prescriptionId;
	private int dosageAmount;
	private int patientId;
	private int doctorId;
	
	public void setPrescriptionName(String prescriptionName) {
		this.prescriptionName = prescriptionName;
	}


	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}


	public void setDosageAmount(int dosageAmount) {
		this.dosageAmount = dosageAmount;
	}


	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}


	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}


	
	
	public String getPrescriptionName() {
		return prescriptionName;
	}
	
	
	public int getPrescriptionId() {
		return prescriptionId;
	}
	
	
	
	public int getDosageAmount() {
		return dosageAmount;
	}
	
	
	public int getPatientId() {
		return patientId;
	}
	
	
	public int getDoctorId() {
		return doctorId;
	}


	
	
	
	
	
	
	
	
}
