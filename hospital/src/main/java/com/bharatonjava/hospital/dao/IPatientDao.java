package com.bharatonjava.hospital.dao;

import java.util.List;

import com.bharatonjava.hospital.domain.Patient;

public interface IPatientDao {

	public Patient getPatientById(Long patientId);
	
	public List<Patient> getAllPatients();
	
	public Long savePatient(Patient patient);
	
	public int updatePatient(Patient patient);
	
	public int deletePatient(Patient patient);
	
	public int deletePatient(Long patientId);
}
