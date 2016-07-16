package com.bharatonjava.therapymanager.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.therapymanager.dao.AddressDao;
import com.bharatonjava.therapymanager.dao.EnumDao;
import com.bharatonjava.therapymanager.dao.PatientDao;
import com.bharatonjava.therapymanager.domain.Address;
import com.bharatonjava.therapymanager.domain.HospitalEnum;
import com.bharatonjava.therapymanager.domain.Patient;
import com.bharatonjava.therapymanager.utils.Constants;

@Service
public class PatientService {
	private static final Logger logger = LoggerFactory.getLogger(PatientService.class);
	private PatientDao patientDao;
	private AddressDao addressDao;
	private EnumDao enumDao;
	
	@Autowired
	public void setPatientDao(PatientDao patientDao) {
		this.patientDao = patientDao;
	}
	
	@Autowired
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}
	
	@Autowired
	public void setEnumDao(EnumDao enumDao) {
		this.enumDao = enumDao;
	}
	
	@Transactional
	public int registerNewPatient(Patient patient){
		int addressId = addressDao.createAddress(patient.getAddress());
		patient.getAddress().setAddressId(addressId);
		int patientId = patientDao.createPatient(patient);
		return patientId;
	}
	
	@Transactional
	public List<HospitalEnum> getBloodGroups(){
		
		List<HospitalEnum> bloodGroups = this.enumDao.getHospitalEnumByGroup(Constants.ENUM_GROUP_BLOOD_GROUP);
		return bloodGroups;
	}
	
	@Transactional
	public Patient getPatientById(Integer patientId){
		
		Patient patient = this.patientDao.getPatient(patientId);
		if(patient != null){
			Address address = this.addressDao.getAddressById(patient.getAddress().getAddressId());
			patient.setAddress(address);
		}
		return patient;
	}
	
	@Transactional
	public List<Patient> searchPatients(String query){
		
		List<Patient> patients = patientDao.searchPatients(query);
		logger.info("patients: {}", patients);
		return patients;
	}
}