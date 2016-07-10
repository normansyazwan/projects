package com.bharatonjava.therapymanager.domain;

import java.util.Date;

public class Patient {

	private int patientId;
	private String firstName;
	private String lastName;
	private String gender;
	private Date dob;
	
	private String bloodGroup;
	private String existingAilments;
	private String allergies;
	
	private String mobile;
	private String email;
	private String occupation;
	
	private Address address;

	// constructor
	public Patient() {
	}
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getExistingAilments() {
		return existingAilments;
	}
	public void setExistingAilments(String existingAilments) {
		this.existingAilments = existingAilments;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
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
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", dob="
				+ dob + ", bloodGroup=" + bloodGroup + ", existingAilments="
				+ existingAilments + ", allergies=" + allergies + ", mobile="
				+ mobile + ", email=" + email + ", occupation=" + occupation
				+ ", address=" + address + "]";
	}
	
}
