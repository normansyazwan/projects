package com.bharatonjava.therapymanager.domain;

import java.util.Date;

public class Sitting {
	
	private Long assessmentId;
	private Long sittingId;
	private String treatment;
	private Double fees;
	// audit fields
	private Date createdDate;
	private Date updatedDate;
	
	public Sitting() {
	}

	public Long getAssessmentId() {
		return assessmentId;
	}
	
	public void setAssessmentId(Long assessmentId) {
		this.assessmentId = assessmentId;
	}
	
	public Long getSittingId() {
		return sittingId;
	}

	public void setSittingId(Long sittingId) {
		this.sittingId = sittingId;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Sitting [assessmentId=" + assessmentId + ", sittingId="
				+ sittingId + ", treatment=" + treatment + ", fees=" + fees
				+ ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + "]";
	}
	
}
