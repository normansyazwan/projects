package com.bharatonjava.therapymanager.web.patient;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bharatonjava.therapymanager.domain.HospitalEnum;
import com.bharatonjava.therapymanager.domain.Patient;
import com.bharatonjava.therapymanager.services.PatientService;
import com.bharatonjava.therapymanager.utils.Constants;

@Controller
@RequestMapping(value = "/patients")
public class PatientController {

	private static final Logger logger = LoggerFactory
			.getLogger(PatientController.class);

	private PatientValidator patientValidator;
	private PatientService patientService;
	

	@Autowired
	public void setPatientValidator(PatientValidator patientValidator) {
		this.patientValidator = patientValidator;
	}

	
	@Autowired
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}
	
	
	

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		// CONVERT empty date to null
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				Constants.DATE_FORMAT_SLASHED);
		dateFormat.setLenient(false);
		// true passed to CustomDateEditor constructor means convert empty
		// String to null
		binder.registerCustomEditor(LocalDate.class, new CustomDateEditor(
				dateFormat, true));

	}

	
	@ExceptionHandler(Exception.class)
	public String defaultExceptionHandler(Exception ex) {
		logger.error("Exception occured in PatientController. ", ex);
		return "error";
	}

	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerPatient() {

		ModelAndView mav = new ModelAndView();
		Patient patient = new Patient();
		
		List<HospitalEnum> bloodGroups = this.patientService.getBloodGroups();
		
		logger.info("bloodGroups : {} ",bloodGroups);
		mav.addObject("patient", patient);
		mav.addObject("bloodGroups", bloodGroups);
		
		mav.setViewName(Constants.VIEW_PATIENT_REGISTER_FORM);

		return mav;
	}

	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerPatientHandler(
			@ModelAttribute("patient") Patient patient, BindingResult result,
			ModelMap model) {

		logger.info("Inside registerPatientHandler() : {}", patient);
		ModelAndView mav = new ModelAndView();

		patientValidator.validate(patient, result);

		if (result.hasErrors()) {
			logger.debug("Errors in paient form:  {} ", result.getAllErrors());
			// for blood group drop down
			List<HospitalEnum> bloodGroups = this.patientService.getBloodGroups();
			mav.addObject("bloodGroups", bloodGroups);
			mav.addObject("patient", patient);
			mav.setViewName(Constants.VIEW_PATIENT_REGISTER_FORM);
			return mav;
		}

		patientService.registerNewPatient(patient);
		mav.setViewName(Constants.VIEW_PATIENT_REGISTER_FORM);
		return mav;
	}

	
	@RequestMapping(value = "/{patientId}/profile", method = RequestMethod.GET)
	public ModelAndView patientProfile(Integer patientId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Constants.VIEW_PATIENT_PROFILE);
		return mav;
	}
	
}
