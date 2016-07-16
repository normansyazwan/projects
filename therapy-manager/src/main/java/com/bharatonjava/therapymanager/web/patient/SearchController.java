package com.bharatonjava.therapymanager.web.patient;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bharatonjava.therapymanager.domain.Patient;
import com.bharatonjava.therapymanager.services.PatientService;
import com.bharatonjava.therapymanager.utils.Constants;

@Controller
@RequestMapping(value = "/search")
public class SearchController {

	private static final Logger logger = LoggerFactory
			.getLogger(SearchController.class);

	private PatientService patientService;

	@Autowired
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {

	}

	/**
	 * Handles search functionality on the header
	 * @param query
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView searchHandler(
			@RequestParam(name = "q", required = false) String query) {
		
		logger.info("Search Query: {}", query);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Constants.VIEW_PATIENT_SEARCH_RESULT);
		mav.addObject("q", query);
		List<Patient> patients = null;
		if(StringUtils.isNotBlank(query)){
			patients = this.patientService.searchPatients(query);
			mav.addObject("patients", patients);
		}else{
			logger.info("search query was blank");
		}
		return mav;
	}
}
