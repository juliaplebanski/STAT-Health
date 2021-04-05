package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Visit;

public interface VisitDAO {

	//List<Visit>getAllScheduledVisitsForDoctor(int doctorId);
	//List<Visit>getAllScheduledVisitsForPatient(int patientId);
    List<Visit>getAllAvailableVisitsByDoctorId(int doctorId);
	
}
