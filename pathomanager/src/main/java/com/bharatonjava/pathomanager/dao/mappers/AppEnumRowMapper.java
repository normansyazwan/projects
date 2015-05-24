package com.bharatonjava.pathomanager.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.pathomanager.domain.AppEnum;

public class AppEnumRowMapper implements RowMapper<AppEnum> {

	@Override
	public AppEnum mapRow(ResultSet rs, int rowNum) throws SQLException {
		AppEnum e = new AppEnum();
		e.setEnumId(rs.getLong("ENUM_ID"));
		e.setEnumGroup(rs.getString("ENUM_GROUP"));
		e.setEnumValue(rs.getString("ENUM_VALUE"));
		return e;
	}

	

}
