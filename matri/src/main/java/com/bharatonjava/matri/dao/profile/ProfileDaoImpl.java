package com.bharatonjava.matri.dao.profile;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
		// TODO Auto-generated method stub
		return 0;
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
