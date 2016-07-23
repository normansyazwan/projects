package com.bharatonjava.therapymanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.therapymanager.domain.Assesment;

public class AssesmentRowMapper implements RowMapper<Assesment>{

	@Override
	public Assesment mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Assesment a = new Assesment();
		
		
		return a;
	}

}
