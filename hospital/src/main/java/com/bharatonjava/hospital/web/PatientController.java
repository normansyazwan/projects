package com.bharatonjava.hospital.web;

import java.util.List;

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

import com.bharatonjava.hospital.domain.HospitalEnum;
import com.bharatonjava.hospital.domain.Patient;
import com.bharatonjava.hospital.services.EnumService;
import com.bharatonjava.hospital.services.PatientService;
import com.bharatonjava.hospital.utils.Constants;
import com.bharatonjava.hospital.web.validators.PatientValidator;

@Controller
//@RequestMapping(value="/patient")
public class PatientController {

	private static final Logger log = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private PatientValidator patientValidator;
	
	@Autowired
	private EnumService enumService;
		
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}
	
	public void setPatientValidator(PatientValidator patientValidator) {
		this.patientValidator = patientValidator;
	}
	
	public void setEnumService(EnumService enumService) {
		this.enumService = enumService;
	}
	
	@RequestMapping(value="/patient/add", method = RequestMethod.GET)
	public String patientShowForm(Model model){
		Patient patient = new Patient();
		model.addAttribute("patient", patient);
		List<HospitalEnum> hospEnums = this.enumService.getEnumsByGroup("CITY");
		model.addAttribute("hospEnums", hospEnums);
		return "patientRegistration";
	}
	
	/**
	 * This method will handle patient Add and Edit cases
	 * @param model
	 * @param patient
	 * @param errors
	 * @return
	 */
	@RequestMapping(value="/patient/add", method = RequestMethod.POST)
	public String patientSubmit(@ModelAttribute("patient") Patient patient, BindingResult result, ModelMap model){
		log.info("Patient: "+patient);
		Long savedPatientId = 0L;
		int updateCount = 0;
		
		patientValidator.validate(patient, result);
		
		if(result.hasErrors())
		{
			log.info("Errors:  {} ",result.getAllErrors());
			List<HospitalEnum> hospEnums = this.enumService.getEnumsByGroup("CITY");
			model.addAttribute("hospEnums", hospEnums);
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
	
	@RequestMapping(value="/patient/edit/{id}", method = RequestMethod.GET)
	public String preparePatientEditForm(@PathVariable Long id, Model model){
		
		Patient patient = patientService.getPatientById(id);
		
		model.addAttribute("patient", patient);
		return Constants.PATIENT_REGISTRATION_PAGE;
	}
	
	@RequestMapping(value="/patients", method = RequestMethod.GET)
	public String allPatients(Model model){

		model.addAttribute("patients", patientService.getAllPatients());
		
		return "listPatients";
	}
	
	@RequestMapping(value="/patients/{id}", method = RequestMethod.GET)
	public String getPatientById(@PathVariable Long id, Model model){
		Patient patient = patientService.getPatientById(id);
		model.addAttribute("patient", patient);
		return "patientProfile";
	}
	
	
}
