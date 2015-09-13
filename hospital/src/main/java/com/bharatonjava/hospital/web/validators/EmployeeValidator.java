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

import com.bharatonjava.hospital.domain.Employee;
import com.bharatonjava.hospital.domain.Patient;
import com.bharatonjava.hospital.utils.Constants;

@Component
public class EmployeeValidator implements Validator {

	private static final Logger log = LoggerFactory
			.getLogger(EmployeeValidator.class);

	private Pattern pattern;
	private Matcher matcher;
	
	@Override
	public boolean supports(Class<?> patient) {
		return Patient.class.isAssignableFrom(patient);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Employee e = null;
		if (target instanceof Employee) {
			e = (Employee) target;
		}

		// name validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
				"fieldIsRequired", "First Name is required");

		if (e.getGender() == null
				|| !(e.getGender().equals("Male") || e.getGender().equals(
						"Female"))) {
			errors.rejectValue("gender", "patient.gender.required",
					"Please select Gender");
		}

		if (e.getDateOfBirth() == null) {
			errors.rejectValue("dateOfBirth", "patient.dob.null",
					"Date of Birth is required.");
		} else if (e.getDateOfBirth().after(new Date())) {
			errors.rejectValue("dateOfBirth", "patient.dob.future",
					"Date of Birth should be in the past");
		}

		// date of joining should not be empty
		if (e.getDateOfJoining() == null) {
			errors.rejectValue("dateOfJoining", "patient.doj.null",
					"Date of Joining is required");
		}
		
		// mobile number if provided, should be 10 digits only
		log.info("mobileNumber: {}", e.getMobile());
		if (e.getMobile() != null && e.getMobile().trim().length() != 0) {
			if (e.getMobile().matches("\\d+") || e.getMobile().length() != 10) {
				errors.rejectValue("mobile", "patient.mobile",
						"Mobile number should be 10 digit");
			}
		}

		// email validation in spring
		if (!(e.getEmail() != null && e.getEmail().isEmpty())) {
			log.debug("inside email validation if condition");
			pattern = Pattern.compile(Constants.EMAIL_PATTERN);
			matcher = pattern.matcher(e.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "email.incorrect",
						"Enter a correct email");
				log.info("Email is incorrect: "+ e.getEmail());
			}
		}else{
			log.debug("inside email validation else condition");
		}
		
		// designation should not be empty
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "designation",
				"fieldIsRequired", "Designation is required");


	}

}
