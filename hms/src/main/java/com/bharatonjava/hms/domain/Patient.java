package com.bharatonjava.hms.domain;

import java.util.List;

public class Patient {
	
	private Long patientId;
	private String firstName;
	private String lastName;
	private String phone;
	private String mobile;
	private String email;
	private Address address;
	private List<Prescription> prescriptions;
	
}
