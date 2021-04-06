package com.techelevator.dao;

import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.model.Visit;

public class JDBCVisitDAO implements VisitDAO{
	
	private JdbcTemplate jdbcTemplate;

	public JDBCVisitDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	

	@Override
	public List<Visit> getAllAvailableVisitsByDoctorId(int doctorId, LocalDate dateOfVisit) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	
}
