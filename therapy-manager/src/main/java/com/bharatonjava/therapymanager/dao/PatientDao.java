package com.bharatonjava.therapymanager.dao;

import java.util.List;

import com.bharatonjava.therapymanager.domain.Assesment;
import com.bharatonjava.therapymanager.domain.Patient;
import com.bharatonjava.therapymanager.domain.Sitting;

public interface PatientDao {

	public Long createPatient(Patient patient);
	public int updatePatient(Patient patient);
	public int deletePatient(Long patientId);
	public Patient getPatient(Long patientId);
	// search methods
	public List<Patient> searchPatients(String query);
	
	//assesment
	public Long createNewAssesment(Assesment assesment);
	public List<Assesment> getAssessmentsForPatient(Long patientId, boolean activeOnly);
	public int addNewSittingToAssessment(Sitting sitting);
	public List<Sitting> getSittingsForAssessment(Long assessmentId);
}
