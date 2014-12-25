package com.bharatonjava.ebroker.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bharatonjava.ebroker.dao.IExecutiveDao;
import com.bharatonjava.ebroker.domain.Executive;

@Service
public class ExecutiveService {

	private IExecutiveDao executiveDao;
	
	public void setExecutiveDao(IExecutiveDao executiveDao) {
		this.executiveDao = executiveDao;
	}
	
	
	@Transactional
	public void saveExecutive(Executive executive){
		executiveDao.saveExecutive(executive);
	}
	
	@Transactional
	public List<Executive> getAllExecutives() {
		return executiveDao.getAllExecutives();
	}
}
