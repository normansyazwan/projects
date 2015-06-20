package com.bharatonjava.elite.dao;

import java.util.List;

import com.bharatonjava.elite.domain.Patient;


public interface IPatientDao {

	public Patient getPatientById(Long patientId);
	
	public Long savePatient(Patient patient);
	
	public void updatePatient(Patient patient);
	
	public Long deletePatient(Long patientId);

	public List<Patient> getPatients();
	
}
