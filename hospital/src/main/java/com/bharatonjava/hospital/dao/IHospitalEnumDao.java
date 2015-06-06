package com.bharatonjava.hospital.dao;

import java.util.List;

import com.bharatonjava.hospital.domain.HospitalEnum;

public interface IHospitalEnumDao {

	public HospitalEnum getEnumById(Long enumId);
	
	public List<HospitalEnum> getEnumsByGroup(String enumGroup);
	
}
