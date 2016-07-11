package com.bharatonjava.therapymanager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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

		int returnValue = 0;
		String sql = "INSERT INTO PATIENTS (FIRST_NAME,LAST_NAME,GENDER,DATE_OF_BIRTH,BLOOD_GROUP,"
				+ "EXISTING_AILMENTS,ALLERGIES,MOBILE,EMAIL,OCCUPATION,ADDRESS_ID)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		this.jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				
				final PreparedStatement ps =conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				ps.setString(1, patient.getFirstName());
				ps.setString(2, patient.getLastName());
				ps.setString(3, patient.getGender());
				ps.setDate(4, new java.sql.Date(patient.getDob().getTime()));
				ps.setString(5, patient.getBloodGroup());
				ps.setString(6, patient.getExistingAilments());
				ps.setString(7, patient.getAllergies());
				ps.setString(8, patient.getMobile());
				ps.setString(9, patient.getEmail());
				ps.setString(10, patient.getOccupation());
				ps.setInt(11, patient.getAddress().getAddressId());
				
				return ps;
			}
			
		}, keyHolder);
		
		
		if (keyHolder.getKey() != null) {
			returnValue = keyHolder.getKey().intValue();
			
		} 
		
		logger.info("Patient persisted with patientId : {}", returnValue);
		return returnValue;
		
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
