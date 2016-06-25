package com.bharatonjava.gang.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.gang.dao.IUserDao;
import com.bharatonjava.gang.domain.User;

@Service
public class RegistrationService {

	private IUserDao userDao;
	
	@Autowired
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	@Transactional
	public void saveUserDetails(User user){
		this.userDao.saveUserDetails(user);
	}
	
}
