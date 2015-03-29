package com.bharatonjava.hospital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.hospital.dao.IPatientDao;
import com.bharatonjava.hospital.domain.Patient;

@Service
public class PatientService {
	
	@Autowired
	private IPatientDao patientDao;
	
	
	public void setPatientDao(IPatientDao patientDao) {
		this.patientDao = patientDao;
	}
	
	@Transactional
	public Long savePatient(Patient patient) {
		return patientDao.savePatient(patient);
	}
	
	@Transactional
	public List<Patient> getAllPatients(){
		return patientDao.getAllPatients();
	}
}
