package com.bharatonjava.matri.dao.profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.bharatonjava.matri.domain.Profile;

@Repository(value="profileDao")
public class ProfileDaoImpl implements ProfileDao{

	private static final Logger logger = LoggerFactory.getLogger(ProfileDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int saveProfile(Profile profile) {
		
		String sql = "INSERT INTO PROFILES(FIRST_NAME,MIDDLE_NAME,LAST_NAME, DATE_OF_BIRTH, GENDER, MARITAL_STATUS"
				+ ",HAVE_CHILDREN,MOTHER_TONGUE,RELIGION,CASTE) VALUES"
				+ "( ?,?,?,?,?,?,?,?,?,?)";
		
		int count = this.jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection c) throws SQLException {
				
				PreparedStatement p = c.prepareStatement(sql);
				
				p.setString(1, profile.getFirstName());
				p.setString(2, profile.getMiddleName());
				p.setString(3, profile.getLastName());
				if(profile.getDateOfBirth() != null){
					p.setDate(4, new java.sql.Date(profile.getDateOfBirth().getTime()));
				}else{
					p.setDate(4, null);
				}
				p.setString(5, profile.getGender());
				p.setString(6, profile.getMaritalStatus());
				p.setString(7, profile.getHaveChildren());
				p.setString(8, profile.getMotherToungue());
				p.setString(9, profile.getReligion());
				p.setString(10, profile.getCaste());
				return p;
			}
		});
		
		return count;
	}

	@Override
	public int updateProfile(Profile profile) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProfile(Long profileId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Profile getProfileById(Long profileId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profile> getProfiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profile> getProfiles(int countOfProfiles) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
