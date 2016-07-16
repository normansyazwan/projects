package com.bharatonjava.therapymanager.dao;

import java.util.List;

import com.bharatonjava.therapymanager.domain.Patient;

public interface PatientDao {

	public int createPatient(Patient patient);
	public int updatePatient(Patient patient);
	public int deletePatient(Long patientId);
	public Patient getPatient(Long patientId);
	// search methods
	public List<Patient> searchPatients(String query);
	
}
