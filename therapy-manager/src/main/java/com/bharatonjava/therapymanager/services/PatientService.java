package com.bharatonjava.therapymanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.therapymanager.dao.AddressDao;
import com.bharatonjava.therapymanager.dao.PatientDao;
import com.bharatonjava.therapymanager.domain.Patient;

@Service
public class PatientService {

	private PatientDao patientDao;
	private AddressDao addressDao;
	
	@Autowired
	public void setPatientDao(PatientDao patientDao) {
		this.patientDao = patientDao;
	}
	
	@Autowired
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}
	
	@Transactional
	public void registerNewPatient(Patient patient){
		patientDao.createPatient(patient);
		addressDao.createAddress(patient.getAddress());
	}
}
