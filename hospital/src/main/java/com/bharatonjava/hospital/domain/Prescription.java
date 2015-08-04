package com.bharatonjava.hospital.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PRESCRIPTION")
public class Prescription {
	
	private Long prescriptionId;
	private String symptoms;
	private String prescription;
	private String medicalTests;
	private String comments;
	private Date createdTimestamp;
	
	private Patient patient;
	
	public Prescription() {
		createdTimestamp = new Date();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRESCRIPTION_ID")
	public Long getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(Long prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	@Column(name = "SYMPTOMS", length = 500)
	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	@Column(name = "PRESCRIPTION", length = 500)
	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	@Column(name = "MEDICAL_TESTS", length = 300)
	public String getMedicalTests() {
		return medicalTests;
	}

	public void setMedicalTests(String medicalTests) {
		this.medicalTests = medicalTests;
	}

	@Column(name = "COMMENTS", length = 500)
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name = "CREATED_TIMESTAMP")
	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}
	
	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	
	@ManyToOne
	@JoinTable(name="PATIENT_PRESCRIPTION",
		joinColumns=@JoinColumn(name="PRESCRIPTION_ID"))
	@JoinColumn(name = "PERSON_ID")
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((prescriptionId == null) ? 0 : prescriptionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prescription other = (Prescription) obj;
		if (prescriptionId == null) {
			if (other.prescriptionId != null)
				return false;
		} else if (!prescriptionId.equals(other.prescriptionId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prescription [prescriptionId=" + prescriptionId + ", symptoms="
				+ symptoms + ", prescription=" + prescription
				+ ", medicalTests=" + medicalTests + ", comments=" + comments
				+ "]";
	}

}
