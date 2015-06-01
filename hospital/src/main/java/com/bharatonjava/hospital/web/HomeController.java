package com.bharatonjava.hospital.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "homepage";
	}
	
	@RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
	public String aboutUs() {
		return "aboutPage";
	}
	
	@RequestMapping(value = "/contactUs", method = RequestMethod.GET)
	public String contactUs() {
		return "contactPage";
	}
}