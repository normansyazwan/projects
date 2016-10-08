package com.bharatonjava.matri.dao.profile;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.matri.domain.Profile;

public class ProfileRowMapper implements RowMapper<Profile>{

	@Override
	public Profile mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Profile p = new Profile();
		p.setFirstName(rs.getString("FIRST_NAME"));
		p.setMiddleName(rs.getString("MIDDLE_NAME"));
		p.setLastName(rs.getString("LAST_NAME"));
		
		return p;
	}

}
