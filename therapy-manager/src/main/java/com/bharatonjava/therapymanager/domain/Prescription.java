package com.bharatonjava.therapymanager.domain;

import java.util.Date;


public class Prescription {
	
	private Long prescriptionId;
	private String symptoms;
	private String treatment;
	private String medicalTests;
	private String comments;
	private Date createdTimestamp;
	private Long patientId;
	
	
	public Prescription() {
		createdTimestamp = new Date();
	}

	public Long getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(Long prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getTreatment() {
		return treatment;
	}
	
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getMedicalTests() {
		return medicalTests;
	}

	public void setMedicalTests(String medicalTests) {
		this.medicalTests = medicalTests;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}
	
	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	
	public Long getPatientId() {
		return patientId;
	}
	
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
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
				+ symptoms + ", treatment=" + treatment
				+ ", medicalTests=" + medicalTests + ", comments=" + comments
				+ ", createdTimestamp=" + createdTimestamp + ", patientId="
				+ patientId + "]";
	}

}