package com.bharatonjava.hms.dao.patient;

import java.util.List;

import com.bharatonjava.hms.domain.Patient;

public interface IPatientDao {

	public int savePatient(Patient patient);
	
	public void updatePatient(Patient patient);
	
	public void deltePatient(Long patientId);
	
	public Patient getPatientById(Long patientId);
	
	public List<Patient> getAllPatients();
	
}
