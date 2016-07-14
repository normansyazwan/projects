package com.bharatonjava.therapymanager.dao;

import java.util.List;

import com.bharatonjava.therapymanager.domain.HospitalEnum;

public interface EnumDao {

	public void insertHospitalEnum(HospitalEnum hospitalEnum);
	
	public HospitalEnum getHospitalEnumById(Long enumId);
	
	public List<HospitalEnum> getHospitalEnumByGroup(String enumGroup);
	
	public List<HospitalEnum> getAllHospitalEnums();
}
