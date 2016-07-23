package com.bharatonjava.therapymanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.therapymanager.domain.Address;
import com.bharatonjava.therapymanager.domain.Patient;

public class PatientRowMapper implements RowMapper<Patient>{

	@Override
	public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Patient p = new Patient();
		p.setPatientId(rs.getLong("PATIENT_ID"));
		p.setFirstName(rs.getString("FIRST_NAME"));
		p.setLastName(rs.getString("LAST_NAME"));
		p.setGender(rs.getString("GENDER"));
		
		java.sql.Date date  = rs.getDate("DATE_OF_BIRTH");
		if(date != null){
			p.setDob(new Date(date.getTime()));
		}
		
		p.setBloodGroup(rs.getString("BLOOD_GROUP"));
		p.setExistingAilments(rs.getString("EXISTING_AILMENTS"));
		p.setAllergies(rs.getString("ALLERGIES"));
		p.setMobile(rs.getString("MOBILE"));
		p.setEmail(rs.getString("EMAIL"));
		p.setOccupation(rs.getString("OCCUPATION"));
		
		Address a = new Address();
		a.setAddressId(rs.getLong("ADDRESS_ID"));
		p.setAddress(a);
		return p;
	}

}
