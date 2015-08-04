package com.bharatonjava.hospital.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bharatonjava.hospital.domain.VisitStats;
import com.bharatonjava.hospital.services.StatsService;
import com.bharatonjava.hospital.utils.Constants;

@Controller
@RequestMapping(value = "/stats/")
public class StatsController {

	private StatsService statsService;
	
	public StatsController() {
	
	}
	
	@Autowired
	public void setStatsService(StatsService statsService) {
		this.statsService = statsService;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
	}
	
	@RequestMapping(value="/visitTrend", method = RequestMethod.GET)
	public String patientShowForm(Model model){
		
		List<VisitStats> visitStats =statsService.getPatientVisitTrend();
		model.addAttribute("visitStats", visitStats);
		return Constants.VIEW_PATIENT_DAILY_VISIT_STATS;
	}
	
}
