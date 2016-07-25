package com.bharatonjava.therapymanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.therapymanager.domain.Treatment;

public class TreatmentRowMapper implements RowMapper<Treatment> {

	@Override
	public Treatment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Treatment t = new Treatment();
		t.setTreatmentId(rs.getLong("TREATMENT_ID"));
		t.setName(rs.getString("TREATMENT_NAME"));
		t.setFees(rs.getDouble("FEE"));
		return t;
	}

}
