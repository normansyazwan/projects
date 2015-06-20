package com.bharatonjava.elite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.elite.dao.IPatientDao;
import com.bharatonjava.elite.domain.Patient;

@Service
public class PatientService {

	@Autowired
	private IPatientDao patientDao;
	
	public void setPatientDao(IPatientDao patientDao) {
		this.patientDao = patientDao;
	}
	
	@Transactional
	public Patient getPatientById(Long patientId){
		return this.patientDao.getPatientById(patientId);
	}
	
	@Transactional
	public Long savePatient(Patient patient){
		Long patientId = this.patientDao.savePatient(patient);
		return patientId;
	}
	
	@Transactional
	public void updatePatient(Patient patient){
		
	}
	
	@Transactional
	public void deletePatient(Long patientId){
		
	}

	@Transactional
	public List<Patient> getPatients(){
		return this.patientDao.getPatients();
	}

}
