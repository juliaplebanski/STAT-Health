package com.techelevator.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Visit;

@Component
public class JDBCVisitDAO implements VisitDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCVisitDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Visit> getAllAvailableVisitsByDoctorId(int doctorId, LocalDate dateOfVisit) {
		// TODO Auto-generated method stub
		List<Visit> listOfAvailableVisitsByDoctorId = new ArrayList<>();
		String selectSQL = "SELECT doctor_schedule.appointment_start_time, doctor_schedule.appointment_end_time FROM doctor_schedule RIGHT OUTER JOIN visit ON visit.doctor_id = doctor_schedule.doctor_id WHERE visit.doctor_id = ? AND (visit.date_of_visit = ? AND doctor_schedule.appointment_start_time NOT IN (SELECT visit.start_time FROM visit)) OR ? NOT IN (SELECT visit.date_of_visit FROM visit); ";

			
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSQL, doctorId, dateOfVisit, dateOfVisit);
		while (results.next()) {
			listOfAvailableVisitsByDoctorId.add(mapRowToAvailableVisits(results));
		}
		return listOfAvailableVisitsByDoctorId;
	}

	/** used to map the results row to properties of the venueSpace class */
	private Visit mapRowToAvailableVisits(SqlRowSet results) {
		Visit visit = new Visit();
		// only pull out what we need for our query
	//	visit.setDateOfVisit(results.getDate("date_of_visit"));
		// visit.setDoctorId(results.getInt("doctor_id"));
		visit.setEndTime(results.getTime("appointment_end_time"));
		// visit.setPatientId(results.getInt("patient_id"));
		visit.setStartTime(results.getTime("appointment_start_time"));
		// visit.setStatusId(results.getString("status_id"));
		// visit.setVisitId(results.getInt("visit_id"));

		
		return visit;

	}

}
