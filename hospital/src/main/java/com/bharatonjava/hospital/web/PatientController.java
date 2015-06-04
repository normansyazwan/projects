package com.bharatonjava.hospital.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bharatonjava.hospital.domain.Patient;
import com.bharatonjava.hospital.services.PatientService;
import com.bharatonjava.hospital.utils.Constants;
import com.bharatonjava.hospital.web.validators.PatientValidator;

@Controller
@RequestMapping(value="/patient")
public class PatientController {

	private static final Logger log = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private PatientValidator patientValidator;
	
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}
	
	public void setPatientValidator(PatientValidator patientValidator) {
		this.patientValidator = patientValidator;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String patientShowForm(Model model){
		Patient patient = new Patient();
		model.addAttribute("patient", patient);
		return "patientRegistration";
	}
	
	/**
	 * This method will handle patient Add and Edit cases
	 * @param model
	 * @param patient
	 * @param errors
	 * @return
	 */
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String patientSubmit(@ModelAttribute("patient") Patient patient, BindingResult result, ModelMap model){
		log.info("Patient: "+patient);
		Long savedPatientId = 0L;
		int updateCount = 0;
		
		patientValidator.validate(patient, result);
		
		if(result.hasErrors())
		{
			log.info("Errors:  {} ",result.getAllErrors());
			return "patientRegistration";
		}
		
		if(patient.getPatientId() != null)
		{
			log.info("Updating patient");
			patientService.updatePatient(patient);
		}else{
			log.info("Inserting patient");
			patientService.savePatient(patient);
		}
		
		model.addAttribute("status", "Record Saved Successfully.");
			
		return "redirect:/patient/add";
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String preparePatientEditForm(@PathVariable Long id, Model model){
		
		Patient patient = patientService.getPatientById(id);
		
		model.addAttribute("patient", patient);
		return Constants.PATIENT_REGISTRATION_PAGE;
	}
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public String allPatients(Model model){

		model.addAttribute("patients", patientService.getAllPatients());
		
		return "listPatients";
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String getPatientById(@PathVariable Long id, Model model){
		Patient patient = patientService.getPatientById(id);
		model.addAttribute("patient", patient);
		return Constants.PATIENT_PROFILE_PAGE;
	}
}
