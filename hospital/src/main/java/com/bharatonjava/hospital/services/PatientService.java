package com.bharatonjava.hospital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.hospital.dao.IAddressDao;
import com.bharatonjava.hospital.dao.IHospitalEnumDao;
import com.bharatonjava.hospital.dao.IPatientDao;
import com.bharatonjava.hospital.domain.Address;
import com.bharatonjava.hospital.domain.HospitalEnum;
import com.bharatonjava.hospital.domain.Patient;

@Service
public class PatientService {
	
	@Autowired
	private IPatientDao patientDao;
	
	@Autowired
	private IAddressDao addressDao;
	
	@Autowired
	private IHospitalEnumDao hospitalEnumDao;
	
	public void setPatientDao(IPatientDao patientDao) {
		this.patientDao = patientDao;
	}
	
	public void setAddressDao(IAddressDao addressDao) {
		this.addressDao = addressDao;
	}
	
	public void setHospitalEnumDao(IHospitalEnumDao hospitalEnumDao) {
		this.hospitalEnumDao = hospitalEnumDao;
	}
	
	@Transactional
	public Long savePatient(Patient patient) {
		return patientDao.savePatient(patient);
		
	}
	
	@Transactional
	public void updatePatient(Patient patient) {
		patientDao.updatePatient(patient);
	}
	
	@Transactional
	public List<Patient> getAllPatients(){
		List<Patient> patients = patientDao.getAllPatients();
		return patients;
	}
	
	@Transactional
	public Patient getPatientById(Long patientId){
		Patient patient = patientDao.getPatientById(patientId);
		return patient;
	}
}
