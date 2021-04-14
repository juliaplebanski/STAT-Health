package com.techelevator.model;

public class Prescription {

	
	private String prescriptionName;
	private int prescriptionId;
	private String dosageAmount;
	private int patientId;
	private int doctorId;
	private String description;
	private String instructions;
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getInstructions() {
		return instructions;
	}


	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}


	public void setPrescriptionName(String prescriptionName) {
		this.prescriptionName = prescriptionName;
	}


	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}


	public void setDosageAmount(String dosageAmount) {
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
	
	
	
	public String getDosageAmount() {
		return dosageAmount;
	}
	
	
	public int getPatientId() {
		return patientId;
	}
	
	
	public int getDoctorId() {
		return doctorId;
	}


	
	
	
	
	
	
	
	
}
