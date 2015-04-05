package com.bharatonjava.elite.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bharatonjava.elite.domain.Patient;

@Controller
@RequestMapping(value = "/patient")
public class PatientController {

	private static final Logger log = LoggerFactory.getLogger(PatientController.class);
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Patient getPatientById(Long id) {

		Patient p = new Patient();
		p.setPatientId(100L);
		p.setFirstName("Bharat");
		p.setLastName("Sharma");
		
		return p;
	}
	
	@ResponseBody
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Patient> getAllPatients(Long id) {

		List<Patient> lst = new ArrayList<Patient>();
		
		Patient p = new Patient();
		p.setPatientId(100L);
		p.setFirstName("Bharat");
		p.setLastName("Sharma");
		
		Patient p1 = new Patient();
		p1.setPatientId(101L);
		p1.setFirstName("Saumya");
		p1.setLastName("Sharma");
		
		lst.add(p);
		lst.add(p1);
		
		return lst;
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Patient PostService(@RequestBody Patient patient) {
	
		log.info("Patient: "+ patient);
		return patient;
	}
}
