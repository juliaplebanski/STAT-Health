package com.techelevator.dao;

import java.time.LocalDate;
import java.util.List;

import com.techelevator.model.Visit;

public interface VisitDAO {

	// List<Visit>getAllScheduledVisitsForDoctor(int doctorId);
	// List<Visit>getAllScheduledVisitsForPatient(int patientId);
	List<Visit> getAllAvailableVisitsByDoctorId(int patientId, int doctorId, LocalDate dateOfVisit);
	Visit bookAppointment(Visit visit);
	//List <Visit>retrieveListOfUpcomingAppointments();
	public List<Visit> retrieveListOfUpcomingAppointments(int patientId); //no parameters on this method? maybe patientid or doctorid?

}

//SELECT * from visit WHERE patient_id = ? AND date_of_visit > current date