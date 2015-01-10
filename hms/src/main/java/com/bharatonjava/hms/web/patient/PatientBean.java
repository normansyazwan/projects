package com.bharatonjava.hms.web.patient;

import java.util.ArrayList;
import java.util.List;

import com.bharatonjava.hms.domain.Patient;
import com.bharatonjava.hms.services.patient.PatientService;

public class PatientBean {

	private PatientService patientService;
	
	private Patient patient;
	private List<Patient> patients;
	
	private List<Patient> filteredPatients;
	
	
	public PatientBean() {
		patient = new Patient();
		patients = new ArrayList<Patient>();
	}
	
	public PatientService getPatientService() {
		return patientService;
	}
	
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public List<Patient> getPatients() {
		return patients;
	}
	
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	public List<Patient> getFilteredPatients() {
		return filteredPatients;
	}
	
	public void setFilteredPatients(List<Patient> filteredPatients) {
		this.filteredPatients = filteredPatients;
	}
	
	//
	
	
	public void savePatient(){
		System.out.println("patient saved: "+ patient);
		int count = patientService.savePatient(patient);
		System.out.println(count);
		
		
		if(count == 1){
		    patient = null;
		    getAllPatients();
		}
		
	}

	public void getAllPatients(){
		patients = patientService.getAllPatients();
	}
}
