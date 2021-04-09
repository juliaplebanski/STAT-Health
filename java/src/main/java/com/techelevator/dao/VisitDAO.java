package com.techelevator.dao;

import java.time.LocalDate;
import java.util.List;

import com.techelevator.model.Visit;
import com.techelevator.model.VisitReason;

public interface VisitDAO {

	// List<Visit>getAllScheduledVisitsForDoctor(int doctorId);
	// List<Visit>getAllScheduledVisitsForPatient(int patientId);
	List<Visit> getAllAvailableVisitsByDoctorId(int patientId, int doctorId, LocalDate dateOfVisit);
	Visit bookAppointment(Visit visit);
	//List <Visit>retrieveListOfUpcomingAppointments();
	public List<Visit> retrieveListOfUpcomingAppointments(); //no parameters on this method? maybe patientid or doctorid?
	List<VisitReason> retrieveListOfVisitReasons();
}

//SELECT * from visit WHERE patient_id = ? AND date_of_visit > current date