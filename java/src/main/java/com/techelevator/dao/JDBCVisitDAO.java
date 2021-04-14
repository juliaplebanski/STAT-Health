package com.techelevator.dao;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Prescription;
import com.techelevator.model.Visit;
import com.techelevator.model.VisitReason;

@Component
public class JDBCVisitDAO implements VisitDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCVisitDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Visit> getAllAvailableVisitsByDoctorId(int patientId, int doctorId, LocalDate dateOfVisit) {
		// TODO Auto-generated method stub
		List<Visit> listOfAvailableVisitsByDoctorId = new ArrayList<>();
		String selectSQL = "SELECT patient.patient_id, doctor_schedule.doctor_id, doctor_schedule.appointment_start_time FROM doctor_schedule "
				+ "RIGHT OUTER JOIN visit ON visit.doctor_id = doctor_schedule.doctor_id "
				+ "JOIN patient ON patient.doctor_id = doctor_schedule.doctor_id "
				+ "WHERE patient.patient_id = ? AND visit.doctor_id = ? AND (visit.date_of_visit = ? AND doctor_schedule.appointment_start_time "
				+ "NOT IN (SELECT visit.start_time FROM visit) OR ? NOT IN (SELECT visit.date_of_visit FROM visit)) "
				+ "GROUP BY patient.patient_id, doctor_schedule.doctor_schedule_id, doctor_schedule.appointment_start_time "
				+ "ORDER BY patient.patient_id, doctor_schedule.doctor_schedule_id; ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSQL, patientId, doctorId, dateOfVisit, dateOfVisit);
		while (results.next()) {
			listOfAvailableVisitsByDoctorId.add(mapRowToAvailableVisits(results));
		}
		return listOfAvailableVisitsByDoctorId;
	}

	@Override
	public List<VisitReason> retrieveListOfVisitReasons() {
		List<VisitReason> listOfVisitReasons = new ArrayList<>();
		String seletSQL = "SELECT visit_reason_id, reason FROM visit_reason;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(seletSQL);
		while (result.next()) {
			listOfVisitReasons.add(mapRowToVisitReasons(result));
		}

		return listOfVisitReasons;
	}

	@Override
	public Visit bookAppointment(Visit visit) {
		// TODO Auto-generated method stub
		String insertSql = "INSERT INTO visit(patient_id, doctor_id,  date_of_visit, start_time, status_id, visit_reason, description)  VALUES (?,?,?,?,?,?, ?); ";
		jdbcTemplate.update(insertSql, visit.getPatientId(), visit.getDoctorId(), visit.getDateOfVisit(),
				visit.getStartTime(), visit.getStatusId(), visit.getVisitReason(), visit.getDescription());

		return visit;
	}

	/** used to map the results row to properties of the venueSpace class */
	private Visit mapRowToAvailableVisits(SqlRowSet results) {
		Visit visit = new Visit();
		// only pull out what we need for our query
		// visit.setDateOfVisit(results.getDate("date_of_visit"));
		visit.setDoctorId(results.getInt("doctor_id"));
		// visit.setEndTime(results.getTime("appointment_end_time"));
		visit.setPatientId(results.getInt("patient_id"));
		visit.setStartTime(results.getTime("appointment_start_time"));
		// visit.setStatusId(results.getString("status_id"));
		// visit.setVisitId(results.getInt("visit_id"));

		return visit;

	}

	private VisitReason mapRowToVisitReasons(SqlRowSet result) {
		VisitReason visitReason = new VisitReason();
		visitReason.setReason(result.getString("reason"));
		visitReason.setVisitReasonId(result.getInt("visit_reason_id"));
		return visitReason;
	}

	@Override
	public List<Visit> retrieveListOfUpcomingAppointments(int patientId) {
		// TODO Auto-generated method stub
		List<Visit> futureAppointmentsList = new ArrayList<>();

		String sql = "SELECT visit.patient_id, visit.date_of_visit, visit.start_time, visit.status_id, visit.visit_reason, visit.description, doctor.first_name, doctor.last_name FROM visit JOIN doctor ON doctor.doctor_id = visit.doctor_id WHERE visit.patient_id = ? AND visit.date_of_visit > (SELECT CURRENT_DATE) GROUP BY visit.patient_id, visit.date_of_visit, visit.start_time, visit.status_id, visit.visit_reason, visit.description, doctor.first_name, doctor.last_name ORDER BY visit.date_of_visit, visit.start_time;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
		while (results.next()) {
			futureAppointmentsList.add(mapRowToUpcomingAppointments(results));

		}
		return futureAppointmentsList;
	}

	private Visit mapRowToUpcomingAppointments(SqlRowSet results) {
		Visit visit = new Visit();
		visit.setPatientId(results.getInt("patient_id"));
		visit.setDateOfVisit(results.getDate("date_of_visit"));
		visit.setStartTime(results.getTime("start_time"));
		visit.setStatusId(results.getString("status_id"));
		visit.setVisitReason(results.getString("visit_reason"));
		visit.setDescription(results.getString("description"));
		visit.setDoctorFirstName(results.getString("first_name"));
		visit.setDoctorLastName(results.getString("last_name"));
		return visit;
	}

	@Override
	public List<Prescription> viewListOfPrescriptions(int patientId) {
		List<Prescription> prescriptionList = new ArrayList<>();

		String sql = "SELECT prescription.patient_id, prescription.prescription_name, prescription.dosage_amount FROM prescription WHERE patient_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
		while (results.next()) {
		prescriptionList.add(mapRowToPrescriptionList(results));
		

}
		return prescriptionList;
	}


private Prescription mapRowToPrescriptionList(SqlRowSet results) {
	Prescription prescription = new Prescription();
	prescription.setPrescriptionName(results.getString("prescription_name"));
	prescription.setPrescriptionId(results.getInt("prescription_id"));
	prescription.setDosageAmount(results.getInt("dosage_amount"));
	prescription.setPatientId(results.getInt("patient_id"));
	prescription.setDoctorId(results.getInt("doctor_id"));
	
	return prescription;
}
}
