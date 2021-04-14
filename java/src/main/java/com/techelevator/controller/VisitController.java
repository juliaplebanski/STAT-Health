package com.techelevator.controller;
import org.springframework.http.HttpStatus;
import java.time.LocalDate;
import java.util.List;
import com.techelevator.dao.VisitDAO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.Prescription;
import com.techelevator.model.Visit;
import com.techelevator.model.VisitReason;

@RestController
@CrossOrigin
//@PreAuthorize("isAuthenticated()")

//Mapping starts here
@RequestMapping(path = "/home")
public class VisitController {

	@Autowired
	VisitDAO visitDao;

//	Mapped as a GET Method using base url of /visit
	@RequestMapping(path = "/scheduling/{patientId}/{doctorId}/{dateOfVisit}", method = RequestMethod.GET)
	public List<Visit> getAllAvailableVisitsByDoctorId(@PathVariable int patientId, @PathVariable int doctorId, @PathVariable String dateOfVisit) {
		return visitDao.getAllAvailableVisitsByDoctorId(patientId, doctorId, LocalDate.parse(dateOfVisit));

	}
	
	@RequestMapping(path = "/scheduling", method = RequestMethod.GET)
	public List<VisitReason> retrieveListOfVisitReasons() {
		return visitDao.retrieveListOfVisitReasons();
	
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path = "/scheduling", method = RequestMethod.POST)
	public Visit bookAppointment (@RequestBody Visit visit) {
		System.out.println(visit.getDateOfVisit());
		return visitDao.bookAppointment(visit);
	
	}
	

	@RequestMapping(path = "/{patientId}", method = RequestMethod.GET) 
	public List<Visit> retrieveListOfUpcomingAppointments(@PathVariable int patientId) { 
		return visitDao.retrieveListOfUpcomingAppointments(patientId);
	
	}
	
	
	@RequestMapping(path = "/medications/{patientId}", method = RequestMethod.GET) 
	public List<Prescription> viewListOfPrescriptions(@PathVariable int patientId) { 
		return visitDao.viewListOfPrescriptions(patientId);
	
	}
	
	
}
