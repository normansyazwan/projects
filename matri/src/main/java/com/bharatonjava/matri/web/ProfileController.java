package com.bharatonjava.matri.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bharatonjava.matri.domain.Profile;
import com.bharatonjava.matri.utils.Constants;
import com.bharatonjava.matri.utils.Utils;

@Controller
public class ProfileController {

	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		// CONVERT empty date to null
		SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_SLASHED);
		dateFormat.setLenient(false);
		// true passed to CustomDateEditor constructor means convert empty
		// String to null
		/*
		 * binder.registerCustomEditor(LocalDate.class, new CustomDateEditor(
		 * dateFormat, true));
		 */
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true, 10));
	}

	@ExceptionHandler(Exception.class)
	public String defaultExceptionHandler(Exception ex) {
		logger.error("Exception occured in ProfileController. ", ex);
		return "error";
	}

	@RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
	public ModelAndView showProfile(@PathVariable("id") Long profileId) {
		logger.info("Inside showProfile method : profileId={}", profileId);
		ModelAndView mav = new ModelAndView();

		mav.setViewName("profileRegistration");
		return mav;
	}

	@RequestMapping(value = "/profile/{id}/edit", method = RequestMethod.GET)
	public ModelAndView showEditProfileForm(@PathVariable("id") Long profileId) {
		logger.info("Inside showEditProfileForm method. profileId={}", profileId);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("profileRegistration");
		return mav;
	}

	@RequestMapping(value = "/profile/new", method = RequestMethod.GET)
	public ModelAndView showProfileForm() {
		logger.info("Inside showProfileForm method");
		ModelAndView mav = new ModelAndView();

		Profile profile = new Profile();
		mav.addObject("profile", profile);

		mav.addObject("maritalStatusList", Utils.getMaritalStatus());
		
		mav.setViewName("profileRegistration");
		return mav;
	}

	@RequestMapping(value = "/profile/new", method = RequestMethod.POST)
	public ModelAndView processProfileForm(Profile profile) {

		logger.info("Inside processProfileForm method. profile={}", profile);

		ModelAndView mav = new ModelAndView();

		// decide based on profileId in the submitted form.

		mav.setViewName("profileRegistration");
		return mav;

	}

	@RequestMapping(value = "/profile/{id}/deactivate", method = RequestMethod.POST)
	public ModelAndView deactivateProfile(@PathVariable("id") Long profileId) {

		logger.info("Inside deactivateProfile method. profileId={}", profileId);

		ModelAndView mav = new ModelAndView();

		// decide based on profileId in the submitted form.

		mav.setViewName("profileRegistration");
		return mav;

	}
}
