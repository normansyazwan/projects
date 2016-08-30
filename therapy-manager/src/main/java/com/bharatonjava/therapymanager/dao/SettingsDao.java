package com.bharatonjava.therapymanager.dao;

import java.util.List;

import com.bharatonjava.therapymanager.domain.Treatment;

public interface SettingsDao {

	
	public List<Treatment> getAllTreatments();
	public Treatment getTreatment(Long treatmentId);
	public int deleteTreatment(Long treatmentId);
	public int updateTreatment(Treatment treatment);
	public Long getMaxTreatmentId();
	
}
