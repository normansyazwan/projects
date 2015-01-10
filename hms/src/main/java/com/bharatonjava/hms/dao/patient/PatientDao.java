package com.bharatonjava.hms.dao.patient;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bharatonjava.hms.domain.Patient;

public class PatientDao implements IPatientDao {

	private JdbcTemplate JdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.JdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int savePatient(Patient patient) {

		String sql = "INSERT INTO PATIENTS (FIRST_NAME, LAST_NAME, DATE_OF_BIRTH,PHONE_NO, MOBILE,EMAIL) VALUES"
				+ "(?,?,?,?,?,?)";
		Object[] args = new Object[] { patient.getFirstName(),
				patient.getLastName(), patient.getDob(), patient.getPhone(),
				patient.getMobile(), patient.getEmail() };
		int recordCount = this.JdbcTemplate.update(sql, args);
		return recordCount;
	}

	@Override
	public void updatePatient(Patient patient) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deltePatient(Long patientId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Patient getPatientById(Long patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> getAllPatients() {
		String sql = "SELECT * FROM PATIENTS";
		List<Patient> patients = this.JdbcTemplate.query(sql, new PatientRowMapper());
		return patients;
	}

}
