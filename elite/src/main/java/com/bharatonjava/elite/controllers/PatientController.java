package com.bharatonjava.elite.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bharatonjava.elite.domain.Patient;
import com.bharatonjava.elite.services.PatientService;

@Controller
public class PatientController {

	private static final Logger log = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private PatientService patientService;
	
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
	public Patient getPatientById(Long id) {

		Patient p = null;
		p = this.patientService.getPatientById(id);
		return p;
	}
	
	@ResponseBody
	@RequestMapping(value = "/patients", method = RequestMethod.GET)
	public List<Patient> getAllPatients(Long id) {

		List<Patient> lst = new ArrayList<Patient>();
		lst = this.patientService.getPatients();
		return lst;
	}
	
	
	@RequestMapping(value = "/patient/add", method = RequestMethod.POST)
	public @ResponseBody Patient processPatientRegistrationForm(@RequestBody Patient patient) {
	
		log.info("Post invoked! Patient: "+ patient);
		Long patientId = 0L;
		if(patient != null){
			// this is a new patient so save it
			patientId = patientService.savePatient(patient);
		}else if(patient.getPatientId() > 0L){
			// update patient
		}
		log.info("Patient saved successfully with id : {} ", patientId);
			
		return patient;
	}
}
