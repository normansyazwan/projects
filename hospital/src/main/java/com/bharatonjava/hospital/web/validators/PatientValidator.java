package com.bharatonjava.hospital.web.validators;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bharatonjava.hospital.domain.Patient;

@Component
public class PatientValidator implements Validator {

	private static final Logger log = LoggerFactory
			.getLogger(PatientValidator.class);

	private Pattern pattern;
	private Matcher matcher;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
			   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"; 
	@Override
	public boolean supports(Class<?> patient) {
		return Patient.class.isAssignableFrom(patient);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Patient p = null;
		if (target instanceof Patient) {
			p = (Patient) target;
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
				"fieldIsRequired", "First Name is required.");

		if (p.getGender() == null
				|| !(p.getGender().equals("Male") || p.getGender().equals(
						"Female"))) {
			errors.rejectValue("gender", "patient.gender.required",
					"Please select Gender");
		}

		if (p.getDateOfBirth() == null) {
			errors.rejectValue("dateOfBirth", "patient.dob.null",
					"Date of Birth is required.");
		} else if (p.getDateOfBirth().after(new Date())) {
			errors.rejectValue("dateOfBirth", "patient.dob.future",
					"Date of Birth should be in the past.");
		}

		if (p.getMobile() != null && p.getMobile().trim().length() != 0) {
			if (p.getMobile().matches("\\d+") || p.getMobile().length() != 10) {
				errors.rejectValue("mobile", "patient.mobile",
						"Mobile number should be 10 digit");
			}
		}

		// email validation in spring
		if (!(p.getEmail() != null && p.getEmail().isEmpty())) {
			log.info("inside email validation if condition");
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(p.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "email.incorrect",
						"Enter a correct email");
				log.info("Email is incorrect: "+ p.getEmail());
			}
		}else{
			log.info("inside email validation else condition");
		}

		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth",
		// "dateOfBirthIsRequired");
		// TODO: more validation to be added here
	}

}
