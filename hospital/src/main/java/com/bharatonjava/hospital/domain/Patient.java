package com.bharatonjava.hospital.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PATIENT")
@PrimaryKeyJoinColumn(name = "PATIENT_ID", referencedColumnName = "PERSON_ID")
public class Patient extends Person{

	private String bloodGroup;
	private String existingAilments;
	private String allergies;
	private List<Prescription> prescriptions;
	
	public Patient() {
		prescriptions = new ArrayList<Prescription>();
	}

	@Column(name = "BLOOD_GROUP", length = 50)
	public String getBloodGroup() {
		return bloodGroup;
	}
	
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	@Column(name = "EXISTING_AILMENTS", length = 500)
	public String getExistingAilments() {
		return existingAilments;
	}
	
	public void setExistingAilments(String existingAilments) {
		this.existingAilments = existingAilments;
	}
	
	@Column(name = "ALLERGIES", length = 500)
	public String getAllergies() {
		return allergies;
	}
	
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(joinColumns = @JoinColumn(name = "PERSON_ID"),
			inverseJoinColumns = @JoinColumn(name = "PRESCRIPTION_ID"),
			name = "PATIENT_PRESCRIPTION"
			)
	@OrderBy(value = "prescriptionId DESC")
	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}
	
	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
	
}
