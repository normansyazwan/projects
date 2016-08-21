package com.bharatonjava.therapymanager.domain;

import java.util.Date;

public class DailyEarningsDto {

	private Date createdDate;
	private Double fees;
	//
	private Long patientId;
	private String firstName;
	private String lastName;

	public DailyEarningsDto() {
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
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

	@Override
	public String toString() {
		return "DailyEarningsDto [createdDate=" + createdDate + ", fees="
				+ fees + ", patientId=" + patientId + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}

}
