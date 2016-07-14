package com.bharatonjava.therapymanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.therapymanager.domain.HospitalEnum;

public class HospitalEnumRowMapper implements RowMapper<HospitalEnum>{

	@Override
	public HospitalEnum mapRow(ResultSet rs, int rowNum) throws SQLException {
		HospitalEnum e = new HospitalEnum();
		e.setEnumId(rs.getLong("ENUM_ID"));
		e.setEnumGroup(rs.getString("ENUM_GROUP"));
		e.setEnumValue(rs.getString("ENUM_VALUE"));
		return e;
	}

}
