package com.bharatonjava.hospital.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bharatonjava.hospital.domain.Authority;
import com.bharatonjava.hospital.domain.User;

public class UserResultSetExtractor implements ResultSetExtractor<User> {

	@Override
	public User extractData(ResultSet rs) throws SQLException,
			DataAccessException {

		User user = null;

		while (rs.next()) {

			if (user == null) {
				user = new User();
			}

			if (user.getUsername() == null) {
				user.setUsername(rs.getString("username"));
			}
			if (user.getPassword() == null) {
				user.setPassword(rs.getString("password"));
			}
			if (user.getEnabled() == 0) {
				user.setEnabled(rs.getInt("enabled"));
			}

			Authority authority = new Authority();
			authority.setUsername(rs.getString("username"));
			authority.setAuthority(rs.getString("authority"));
			user.getAuthorities().add(authority);

		}

		return user;
	}

}
