package com.bharatonjava.hospital.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bharatonjava.hospital.services.PatientService;
import com.bharatonjava.hospital.services.StatsService;

@Controller
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	private StatsService statsService;

	private PatientService patientService;
	
	@Value("${prescription.average.for.months}")
	private Integer prescriptionAverageForMonths; 
	
	@Autowired
	public void setStatsService(StatsService statsService) {
		this.statsService = statsService;
	}
	
	@Autowired
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}
	
	public void setPrescriptionAverageForMonths(
			Integer prescriptionAverageForMonths) {
		this.prescriptionAverageForMonths = prescriptionAverageForMonths;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		log.info("Inside home page request handler");
		model.addAttribute("totalPatientCount", patientService.totalPatientCount());
		
		model.addAttribute("averagePatientCount", statsService.getAveragePatientCount(prescriptionAverageForMonths));
		model.addAttribute("prescriptionAverageForMonths", prescriptionAverageForMonths);
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