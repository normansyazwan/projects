package com.bharatonjava.gang.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bharatonjava.gang.domain.User;
import com.bharatonjava.gang.utils.Constants;


@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerUser(){
	
		ModelAndView mav = new ModelAndView();
		User user = new User();
		mav.addObject("user", user);
		mav.setViewName(Constants.VIEW_USER_REGISTER_FORM);
		
		return mav;
	}


	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUserHandler(@ModelAttribute("user") User User,
			BindingResult result, ModelMap model){

		logger.info("Inside registerUserHandler() method"); 
		ModelAndView mav = new ModelAndView();
		
		
		mav.setViewName(Constants.VIEW_USER_REGISTER_FORM);
		return mav;
	}
}
