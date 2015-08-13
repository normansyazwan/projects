package com.bharatonjava.hospital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.hospital.dao.IAddressDao;
import com.bharatonjava.hospital.dao.IHospitalEnumDao;
import com.bharatonjava.hospital.dao.IPatientDao;
import com.bharatonjava.hospital.domain.Patient;
import com.bharatonjava.hospital.domain.Prescription;

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
	
	@Transactional
	public List<Patient> searchPatients(String query){
		List<Patient> patients = patientDao.searchPatients(query);
		return patients;
	}
	
	@Transactional
	public Long savePrescription(Prescription prescription, Long patientId){
		Long prescriptionId = patientDao.savePrescription(prescription, patientId);
		return prescriptionId;
	}
	
	@Transactional
	public Patient getAllPrescriptions(Long patientId){
		Patient patient = patientDao.getAllPrescriptions(patientId);
		return patient;
	}
	
	@Transactional
	public Prescription getPrescription(Long prescriptionId){
		Prescription prescription = patientDao.getPrescription(prescriptionId);
		return prescription;
	}
	
	@Transactional
	public void updatePrescription(Prescription prescription){
		patientDao.updatePrescription(prescription);
	}
}
