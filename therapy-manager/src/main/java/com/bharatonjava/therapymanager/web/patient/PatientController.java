package com.bharatonjava.therapymanager.web.patient;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bharatonjava.therapymanager.domain.Patient;
import com.bharatonjava.therapymanager.utils.Constants;

@Controller
@RequestMapping(value = "/patient")
public class PatientController {
	
	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

	private PatientRegisterationFormValidator patientRegisterationFormValidator;
	
	@Autowired
	public void setPatientRegisterationFormValidator(
			PatientRegisterationFormValidator PatientRegisterationFormValidator) {
		this.patientRegisterationFormValidator = PatientRegisterationFormValidator;
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    
	    // CONVERT empty date to null
	    SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_SLASHED);
	    dateFormat.setLenient(false);
	    // true passed to CustomDateEditor constructor means convert empty String to null
	    binder.registerCustomEditor(LocalDate.class, new CustomDateEditor(dateFormat, true));
	    
	   // binder.setValidator(patientRegisterationFormValidator);
	    
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerPatient(){
	
		
		ModelAndView mav = new ModelAndView();
		Patient patient = new Patient();
		mav.addObject("patient", patient);
		mav.setViewName(Constants.VIEW_PATIENT_REGISTER_FORM);
		
		return mav;
	}


	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerPatientHandler(@ModelAttribute("Patient") Patient patient,
			BindingResult result, ModelMap model){

		logger.info("Inside registerPatientHandler() method"); 
		ModelAndView mav = new ModelAndView();
		
		patientRegisterationFormValidator.validate(patient, result);
		
		if (result.hasErrors()) {
			logger.info("Errors:  {} ", result.getAllErrors());
			mav.addObject("patient", patient);
			mav.setViewName(Constants.VIEW_PATIENT_REGISTER_FORM);
			return mav;
		}
		
		mav.setViewName(Constants.VIEW_PATIENT_REGISTER_FORM);
		return mav;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView PatientLogin(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Constants.VIEW_LOGIN_FORM);
		return mav;
	}
}
