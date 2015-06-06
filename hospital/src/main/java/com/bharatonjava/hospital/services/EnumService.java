package com.bharatonjava.hospital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.hospital.dao.IHospitalEnumDao;
import com.bharatonjava.hospital.domain.HospitalEnum;

@Service
public class EnumService {

	@Autowired
	private IHospitalEnumDao hospitalEnumDao;
	
	public void setHospitalEnumDao(IHospitalEnumDao hospitalEnumDao) {
		this.hospitalEnumDao = hospitalEnumDao;
	}
	
	@Transactional
	public HospitalEnum getEnumById(Long enumId){
		return hospitalEnumDao.getEnumById(enumId);
	}
	
	@Transactional
	public List<HospitalEnum> getEnumsByGroup(String enumGroup){
		return hospitalEnumDao.getEnumsByGroup(enumGroup);
	}
}
