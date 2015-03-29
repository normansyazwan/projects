package com.bharatonjava.hospital.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bharatonjava.hospital.domain.Address;
import com.bharatonjava.hospital.domain.Patient;
import com.bharatonjava.hospital.services.PatientService;

@Controller
@RequestMapping(value="/patient")
public class PatientController {

	private static final Logger log = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private PatientService patientService;
	
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String preparePatientRegistrationForm(){
		
		return "patientRegistration";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String patientRegistrationFormHandler(Model model, Patient patient, Errors errors){
		log.info("Patient: "+patient);
		Long savedPatientId = patientService.savePatient(patient);
		model.addAttribute("savedPatientId", savedPatientId);
		return "patientRegistration";
	}
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public String allPatients(Model model){

		model.addAttribute("patients", patientService.getAllPatients());
		
		return "patients";
	}
	
}
