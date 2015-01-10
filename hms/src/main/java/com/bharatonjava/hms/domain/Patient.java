package com.bharatonjava.hms.domain;

import java.util.Date;
import java.util.List;

public class Patient {
	
	private Long patientId;
	private String firstName;
	private String lastName;
	private Date dob;
	private String phone;
	private String mobile;
	private String email;
	private Address address;
	private List<Prescription> prescriptions;
	
	public Patient() {
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dob=" + dob + ", phone="
				+ phone + ", mobile=" + mobile + ", email=" + email
				+ ", address=" + address + ", prescriptions=" + prescriptions
				+ "]";
	}
	
}
