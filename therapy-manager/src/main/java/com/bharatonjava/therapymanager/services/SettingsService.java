package com.bharatonjava.therapymanager.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.therapymanager.dao.SettingsDao;
import com.bharatonjava.therapymanager.domain.Treatment;

@Service
public class SettingsService {
	private static final Logger logger = LoggerFactory
			.getLogger(SettingsService.class);

	private SettingsDao settingsDao;
	
	@Autowired
	public void setSettingsDao(SettingsDao settingsDao) {
		this.settingsDao = settingsDao;
	}
	
	@Transactional
	public List<Treatment> getAllTreatments(){
		return this.settingsDao.getAllTreatments();
	}
	
	@Transactional
	public Treatment getTreatment(Long treatmentId){
		return this.settingsDao.getTreatment(treatmentId);
	}
	
	@Transactional
	public int updateTreatment(Treatment treatment){
		return this.settingsDao.updateTreatment(treatment);
	}
	
	@Transactional
	public Long getMaxTreatmentId(){
		return this.settingsDao.getMaxTreatmentId();
	}
}
