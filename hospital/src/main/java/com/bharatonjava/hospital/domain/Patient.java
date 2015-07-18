package com.bharatonjava.hospital.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PATIENT")
@PrimaryKeyJoinColumn(name = "PATIENT_ID", referencedColumnName = "PERSON_ID")
public class Patient extends Person{

	private String bloodGroup;
	
	public Patient() {
	}

	@Column(name = "BLOOD_GROUP")
	public String getBloodGroup() {
		return bloodGroup;
	}
	
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
}
