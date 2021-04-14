package com.techelevator.dao;

import java.time.LocalDate;
import java.util.List;

import com.techelevator.model.Prescription;
import com.techelevator.model.Visit;
import com.techelevator.model.VisitReason;

public interface VisitDAO {

	public List<Visit> getAllAvailableVisitsByDoctorId(int patientId, int doctorId, LocalDate dateOfVisit);

	public Visit bookAppointment(Visit visit);

	public List<Visit> retrieveListOfUpcomingAppointments(int patientId);

	public List<VisitReason> retrieveListOfVisitReasons();

	public List<Prescription> viewListOfPrescriptions(int patientId);

	public List<Visit> retrieveListOfPreviousAppointments(int patientId);
}
