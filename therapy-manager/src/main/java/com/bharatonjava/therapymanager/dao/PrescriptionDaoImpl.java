package com.bharatonjava.therapymanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.bharatonjava.therapymanager.domain.Prescription;
import com.bharatonjava.therapymanager.domain.Treatment;

@Repository(value = "prescriptionDao")
public class PrescriptionDaoImpl implements PrescriptionDao {

	private static final Logger logger = LoggerFactory.getLogger(PrescriptionDaoImpl.class);
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Long savePrescription(Prescription prescription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long updatePrescription(Prescription prescription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long deletePrescription(Long prescriptionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prescription getPrescriptionById(Long prescriptionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prescription> getPrescritpions(Long patientId) {
		
		String sql = "select PRESCRIPTION_ID,PATIENT_ID,SYMPTOMS,TREATMENT,"
				+ "MEDICAL_TESTS,COMMENTS,CREATED_TIMESTAMP WHERE PATIENT_ID=?";
		
		List<Prescription> prescriptions = this.jdbcTemplate.query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, patientId);
				
				return ps;
			}
		}, new BeanPropertyRowMapper<Prescription>());
		
		return prescriptions;
	}

	@Override
	public List<Treatment> getTreatments() {
		List<Treatment> treatments = null;
		String sql = "SELECT TREATMENT_ID, TREATMENT_NAME,FEE FROM TREATMENTS ORDER BY TREATMENT_NAME ASC";
		treatments = this.jdbcTemplate.query(sql, new TreatmentRowMapper());
		return treatments;
	}

	@Override
	public Treatment getTreatment(Long treatmentId){
		String sql = "SELECT TREATMENT_ID, TREATMENT_NAME,FEE FROM TREATMENTS WHERE TREATMENT_ID=?";
		Treatment t = (Treatment) this.jdbcTemplate.query(sql, new TreatmentRowMapper());
		return t;
	}
	
}
