package com.bharatonjava.matri.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bharatonjava.matri.dao.profile.ProfileDao;
import com.bharatonjava.matri.domain.Profile;

@Service(value = "profileService")
public class ProfileService {

	private static final Logger logger = LoggerFactory.getLogger(ProfileService.class);
	
	@Autowired
	private ProfileDao profileDao;
	
	public void setProfileDao(ProfileDao profileDao) {
		this.profileDao = profileDao;
	}
	
	public int saveProfile(Profile profile){
		logger.info("Inside profile service : {}",profile);
		return	profileDao.saveProfile(profile); 
	}
}
