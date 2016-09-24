package com.bharatonjava.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bharatonjava.domain.Profile;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showHomePage(ModelAndView mav) {
		logger.info("Inside showHomePage method");

		mav.setViewName("homepage");
		return mav;
	}

	@RequestMapping(value = "/ajax", method = RequestMethod.GET)
	public @ResponseBody List<Profile> ajaxRequest(ModelAndView mav) {
		logger.info("Inside showHomePage method");

		List<Profile> lst = new ArrayList<>();

		Profile p = new Profile();
		p.setFirstName("Bharat");
		p.setLastName("Sharma");
		p.setAge(22);
		lst.add(p);

		return lst;
	}


}
