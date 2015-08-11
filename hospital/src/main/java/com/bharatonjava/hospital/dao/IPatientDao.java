package com.bharatonjava.hospital.dao;

import java.util.List;

import com.bharatonjava.hospital.domain.Patient;
import com.bharatonjava.hospital.domain.Prescription;

public interface IPatientDao {

	public Patient getPatientById(Long patientId);
	
	public List<Patient> getAllPatients();
	
	public Long savePatient(Patient patient);
	
	public void updatePatient(Patient patient);
	
	public void deletePatient(Patient patient);
	
	public void deletePatient(Long patientId);
	
	public List<Patient> searchPatients(String query);
	
	public Long savePrescription(Prescription prescription, Long patientId);
	
	public Patient getAllPrescriptions(Long patientId);
	
	public Prescription getPrescription(Long patientId, Long prescriptionId);
}
