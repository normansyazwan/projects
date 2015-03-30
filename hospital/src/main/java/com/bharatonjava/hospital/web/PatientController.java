package com.bharatonjava.hospital.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bharatonjava.hospital.domain.Patient;
import com.bharatonjava.hospital.services.PatientService;
import com.bharatonjava.hospital.utils.Constants;

@Controller
@RequestMapping(value="/patient")
public class PatientController {

	private static final Logger log = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private PatientService patientService;
	
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String preparePatientRegistrationForm(Model model){
		Patient patient = new Patient();
		model.addAttribute("patient", patient);
		return Constants.PATIENT_REGISTRATION_PAGE;
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String preparePatientEditForm(@PathVariable Long id, Model model){
		
		Patient patient = patientService.getPatientById(id);
		
		model.addAttribute("patient", patient);
		return Constants.PATIENT_REGISTRATION_PAGE;
	}
	
	/**
	 * This method will handle patient Add and Edit cases
	 * @param model
	 * @param patient
	 * @param errors
	 * @return
	 */
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String patientRegistrationFormHandler(Model model, Patient patient, Errors errors){
		log.info("Patient: "+patient);
		Long savedPatientId = 0L;
		int updateCount = 0;
		if(patient.getPatientId() == 0L){
			savedPatientId = patientService.savePatient(patient);
			model.addAttribute("savedPatientId", savedPatientId);
		}else{
			updateCount = patientService.updatePatient(patient);
			model.addAttribute("updateCount", updateCount);
		}
		
		return "patientRegistration";
	}
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public String allPatients(Model model){

		model.addAttribute("patients", patientService.getAllPatients());
		
		return Constants.PATIENTS_PAGE;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String getPatientById(@PathVariable Long id, Model model){
		Patient patient = patientService.getPatientById(id);
		model.addAttribute("patient", patient);
		return Constants.PATIENT_PROFILE_PAGE;
	}
}
