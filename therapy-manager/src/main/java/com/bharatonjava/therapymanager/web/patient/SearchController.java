package com.bharatonjava.therapymanager.web.patient;

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

		ModelAndView mav = new ModelAndView();
		mav.setViewName(Constants.VIEW_PATIENT_SEARCH_RESULT);
		mav.addObject("q", query);
		return mav;
	}
}
