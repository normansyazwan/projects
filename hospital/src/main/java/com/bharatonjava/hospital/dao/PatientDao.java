package com.bharatonjava.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bharatonjava.hospital.dao.mappers.PatientRowMapper;
import com.bharatonjava.hospital.domain.Patient;

@Repository
public class PatientDao implements IPatientDao {

	private static final Logger log = LoggerFactory.getLogger(PatientDao.class);
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Patient getPatientById(Long patientId) {
		log.info("Fetching record for patientId: {}", patientId);
		String sql = "SELECT * FROM PATIENTS WHERE PATIENT_ID = ?";
		Patient patient = (Patient) this.jdbcTemplate.queryForObject(sql,
				new Object[] { patientId }, new PatientRowMapper());
		return patient;
	}

	@Override
	public List<Patient> getAllPatients() {
		String sql = "SELECT * FROM PATIENTS";
		List<Patient> patients = this.jdbcTemplate.query(sql,
				new PatientRowMapper());
		return patients;
	}

	@Override
	public Long savePatient(final Patient patient) {
		log.info("Saving Patient: {}", patient);
		final String sql = "INSERT INTO PATIENTS(FIRST_NAME,LAST_NAME,GENDER,DOB,EMAIL,MOBILE,PHONE, ADDRESS_ID) "
				+ "VALUES(?,?,?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		this.jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql,
						new String[] { "PATIENT_ID" });
				ps.setString(1, patient.getFirstName());
				ps.setString(2, patient.getLastName());
				ps.setString(3, patient.getGender());
				if (patient.getDateOfBirth() != null) {
					ps.setDate(4, new java.sql.Date(patient.getDateOfBirth()
							.getTime()));
				}else{
					ps.setDate(4, null);
				}
				ps.setString(5, patient.getEmail());
				ps.setString(6, patient.getMobile());
				ps.setString(7, patient.getPhone());
				ps.setLong(8, patient.getAddress().getAddressId());
				return ps;
			}
		}, keyHolder);

		if (keyHolder.getKey() != null) {
			log.info("Patient saved successfully. PatientId: {}", keyHolder
					.getKey().longValue());
			return keyHolder.getKey().longValue();
		} else {
			return 0L;
		}
	}

	@Override
	public int updatePatient(Patient patient) {
		log.info("Updating patient: {}", patient);
		String sql = "UPDATE PATIENTS SET FIRST_NAME=?,LAST_NAME=?,GENDER=?,DOB=?,MOBILE=?,PHONE=?,EMAIL=? where PATIENT_ID=?";
		int count = this.jdbcTemplate.update(
				sql,
				new Object[] { patient.getFirstName(), patient.getLastName(),
						patient.getGender(), patient.getDateOfBirth(),
						patient.getMobile(), patient.getPhone(),
						patient.getEmail(), patient.getPatientId() });

		log.info("Record updated: {}", count);
		return count;

	}

	@Override
	public int deletePatient(Patient patient) {

		return 0;
	}

	@Override
	public int deletePatient(Long patientId) {

		return 0;
	}

}
