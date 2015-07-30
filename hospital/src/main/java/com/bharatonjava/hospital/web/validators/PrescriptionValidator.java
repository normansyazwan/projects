package com.bharatonjava.hospital.web.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bharatonjava.hospital.domain.Patient;
import com.bharatonjava.hospital.domain.Prescription;

@Component
public class PrescriptionValidator implements Validator{

	private static final Logger log = LoggerFactory.getLogger(PrescriptionValidator.class);
	
	@Override
	public boolean supports(Class<?> prescription) {
		return Patient.class.isAssignableFrom(prescription);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Prescription prescription = null;
		if(target instanceof Prescription){
			prescription = (Prescription) target;
		}

		log.debug("Presciption: {}", prescription);
		
		// for a prescription atleast symptoms should be entered
		if(prescription.getSymptoms() == null || prescription.getSymptoms().trim().length() <= 0){
			errors.rejectValue("symptoms", "prescription.symptoms.blank", "Symptoms are required for Prescription");
		}
	}
		

}
