package com.bharatonjava.ebroker.dao;

import java.util.List;

import com.bharatonjava.ebroker.domain.Executive;

public interface IExecutiveDao {

	public int saveExecutive(Executive executive);
	
	public int updateExecutive(Executive executive);
	
	public void deleteExecutive(Executive executive);
	
	public List<Executive> getAllExecutives();
	
	public Executive getExecutiveById(Long executiveId);
}
