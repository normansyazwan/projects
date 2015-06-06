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
		Long addressId = this.addressDao.saveAddress(patient.getAddress());
		patient.getAddress().setAddressId(addressId);
		return patientDao.savePatient(patient);
		
	}
	
	@Transactional
	public int updatePatient(Patient patient) {
		return patientDao.updatePatient(patient);
	}
	
	@Transactional
	public List<Patient> getAllPatients(){
		List<Patient> patients = patientDao.getAllPatients();
		
		for(Patient patient : patients){
			if(patient.getAddress().getAddressId() != null){
				Address address = addressDao.getAddressById(patient.getAddress().getAddressId());
				if(address.getCity().getEnumId() != null){
					HospitalEnum city = hospitalEnumDao.getEnumById(address.getCity().getEnumId());
					address.setCity(city);
				}
				patient.setAddress(address);
			}
		}
		
		return patients;
	}
	
	@Transactional
	public Patient getPatientById(Long patientId){
		Patient patient = patientDao.getPatientById(patientId);
		if(patient.getAddress().getAddressId() != null){
			Address address = addressDao.getAddressById(patient.getAddress().getAddressId());
			if(address.getCity().getEnumId() != null){
				HospitalEnum city = hospitalEnumDao.getEnumById(address.getCity().getEnumId());
				address.setCity(city);
			}
			patient.setAddress(address);
		}
		
		return patient;
	}
}
