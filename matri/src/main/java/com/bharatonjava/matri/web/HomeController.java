package com.bharatonjava.matri.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bharatonjava.matri.domain.Profile;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Handles get request to home page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public ModelAndView showHomePage(Model model) {
		logger.info("Inside showHomePage method");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("homepage");
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLoginPage(Model model) {
		logger.info("Inside showLoginPage method");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginpage");
		return mav;
	}
	
	@RequestMapping(value = "/ajax", method = RequestMethod.GET)
	public @ResponseBody List<Profile> ajaxRequest(ModelAndView mav) {
		logger.info("Inside showHomePage method");

		List<Profile> lst = new ArrayList<>();

		Profile p = new Profile();
		p.setFirstName("Bharat");
		p.setLastName("Sharma");
		
		lst.add(p);

		return lst;
	}


}
