package com.bharatonjava.therapymanager.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bharatonjava.therapymanager.domain.Patient;

@Repository
public class PatientDaoImpl implements PatientDao{

	private static final Logger logger = LoggerFactory.getLogger(PatientDaoImpl.class);
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Default constructor
	public PatientDaoImpl() {
	}
	
	@Override
	public int createPatient(Patient patient) {
		logger.info("patient inside dao : {}", patient);
		return 0;
	}

	@Override
	public int updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePatient(int patientId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Patient getPatient(int patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> searchPatients() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
