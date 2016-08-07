package com.bharatonjava.therapymanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.therapymanager.domain.Sitting;

public class SittingRowMapper implements RowMapper<Sitting>{

	@Override
	public Sitting mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Sitting s = new Sitting();
		s.setAssessmentId(rs.getLong("ASSESMENT_ID"));
		s.setSittingId(rs.getLong("SITTING_ID"));
		s.setTreatment(rs.getString("TREATMENT"));
		s.setFees(rs.getDouble("FEE"));
		s.setCreatedDate(rs.getDate("CREATED_DATE"));
		
		return s;
	}

}
