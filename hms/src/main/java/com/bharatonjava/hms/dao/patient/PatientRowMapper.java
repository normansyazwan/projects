package com.bharatonjava.hms.dao.patient;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.hms.domain.Patient;

public class PatientRowMapper implements RowMapper<Patient> {

	@Override
	public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
		Patient p  = new Patient();
		p.setPatientId(rs.getLong("PATIENT_ID"));
		p.setFirstName(rs.getString("FIRST_NAME"));
		p.setLastName(rs.getString("last_name"));
		p.setDob(rs.getDate("DATE_OF_BIRTH"));
		p.setPhone(rs.getString("phone_no"));
		p.setMobile(rs.getString("MOBILE"));
		p.setEmail(rs.getString("email"));
		return p;
	}

}
