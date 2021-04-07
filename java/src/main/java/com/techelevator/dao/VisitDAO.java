package com.techelevator.dao;

import java.time.LocalDate;
import java.util.List;

import com.techelevator.model.Visit;

public interface VisitDAO {

	// List<Visit>getAllScheduledVisitsForDoctor(int doctorId);
	// List<Visit>getAllScheduledVisitsForPatient(int patientId);
	List<Visit> getAllAvailableVisitsByDoctorId(int doctorId, LocalDate dateOfVisit);
	Visit bookAppointment(Visit visit);
}
