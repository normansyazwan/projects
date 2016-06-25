package com.bharatonjava.gang.dao;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bharatonjava.gang.domain.User;

@Repository
public class UserDao implements IUserDao{

private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;  
	
	@Autowired
	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	@Override
	public void saveUserDetails(User user){
		
		String sql = "insert into users username, password, enabled, first_name, last_name"
				+ ",date_of_birth, mobile values(:email, :password, 'true', "
				+ ":firstName, :lastName, :dateOfBirth, :mobile )";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", user.getEmail());
		params.put("password", user.getPasswd());
		params.put("firstName", user.getFirstName());
		params.put("lastName", user.getLastName());
		params.put("dateOfBirth", user.getDateOfBirth());
		params.put("mobile", user.getMobileNumber());
		
		int rowsAffected = this.namedParameterJdbcTemplate.update(sql, params);
		logger.info("{} record inserted in USERS table");
	}
	
}
