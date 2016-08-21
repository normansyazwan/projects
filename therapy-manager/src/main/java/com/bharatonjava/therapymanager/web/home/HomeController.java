package com.bharatonjava.therapymanager.web.home;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bharatonjava.therapymanager.dao.PatientDao;
import com.bharatonjava.therapymanager.utils.Constants;

@Controller
@RequestMapping(value = "/")
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	private PatientDao patientDao;

	@Autowired
	public void setPatientDao(PatientDao patientDao) {
		this.patientDao = patientDao;
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

	@RequestMapping(value = { "/home", "/" }, method = RequestMethod.GET)
	public ModelAndView registerPatient() {

		ModelAndView mav = new ModelAndView();

		Long patientCount = this.patientDao.getPatientCount();
		mav.addObject("patientCount", patientCount);
		mav.setViewName(Constants.VIEW_HOMEPAGE);

		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName(Constants.VIEW_LOGINPAGE);

		return mav;
	}

	@RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
	public String aboutUs() {
		return "aboutUs";
	}

	@RequestMapping(value = "/contactUs", method = RequestMethod.GET)
	public String contactUs() {
		return "contactUs";
	}
	
	@RequestMapping(value = "/disclaimer", method = RequestMethod.GET)
	public String showDisclaimer() {
		return "disclaimer";
	}
}
