package com.techelevator.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.Visit;

@RestController
@CrossOrigin
//@PreAuthorize("isAuthenticated()")

//Mapping starts here
@RequestMapping(path = "/home")
public class VisitController {

	@Autowired
	VisitDAO visitDao;

//	Mapped as a GET Method using base url of /visit
	@RequestMapping(path = "/scheduling/{doctorId}/{dateOfVisit}", method = RequestMethod.GET)
	public List<Visit> getAllAvailableVisitsByDoctorId(@PathVariable int doctorId, @PathVariable String dateOfVisit) {
		return visitDao.getAllAvailableVisitsByDoctorId(doctorId, LocalDate.parse(dateOfVisit));

	}

}
