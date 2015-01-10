package com.bharatonjava.hms.services.patient;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bharatonjava.hms.dao.patient.IPatientDao;
import com.bharatonjava.hms.domain.Patient;

@Service
public class PatientService {

	private IPatientDao patientDao;
	
	public void setPatientDao(IPatientDao patientDao) {
		this.patientDao = patientDao;
	}
	
	@Transactional
	public int savePatient(Patient patient){
		
		int count = patientDao.savePatient(patient);
		return count; 
	}
	
	@Transactional
	public List<Patient> getAllPatients() {
		return patientDao.getAllPatients();
	}
}	
