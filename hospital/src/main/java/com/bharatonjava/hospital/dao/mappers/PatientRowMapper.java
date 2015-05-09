package com.bharatonjava.hospital.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.hospital.domain.Patient;

public class PatientRowMapper implements RowMapper<Patient>{

	@Override
	public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
		Patient p = new Patient();
		p.setPatientId(rs.getLong("PATIENT_ID"));
		p.setFirstName(rs.getString("FIRST_NAME"));
		p.setLastName(rs.getString("LAST_NAME"));
		p.setGender(rs.getString("GENDER"));
		p.setAge(rs.getInt("AGE"));
		p.setEmail(rs.getString("EMAIL"));
		p.setMobile(rs.getString("MOBILE"));
		p.setPhone(rs.getString("phone"));
		return p;
	}

}