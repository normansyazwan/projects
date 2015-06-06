package com.bharatonjava.hospital.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.hospital.domain.HospitalEnum;

public class HospitalEnumRowMapper implements RowMapper<HospitalEnum> {

	@Override
	public HospitalEnum mapRow(ResultSet rs, int rowNum) throws SQLException {
		HospitalEnum e = new HospitalEnum();
		e.setEnumId(rs.getLong("enum_id"));
		e.setEnumGroup(rs.getString("enum_group"));
		e.setEnumValue(rs.getString("enum_value"));
		return e;
	}

}
