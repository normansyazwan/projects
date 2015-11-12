package com.bharatonjava.hospital.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.hospital.domain.Authority;

public class AuthorityRowMapper implements RowMapper<Authority>{

	@Override
	public Authority mapRow(ResultSet rs, int rowNum) throws SQLException {
		Authority a = new Authority();
		a.setUsername(rs.getString("USERNAME"));
		a.setAuthority(rs.getString("authority"));
		return a;
	}

}
