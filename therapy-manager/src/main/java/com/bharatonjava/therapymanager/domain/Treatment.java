package com.bharatonjava.therapymanager.domain;

public class Treatment {

	private Long treatmentId;
	private Long assesmentId;
	private String name;
	private Double fees;

	public Treatment() {
	}

	public Long getTreatmentId() {
		return treatmentId;
	}
	
	public void setTreatmentId(Long treatmentId) {
		this.treatmentId = treatmentId;
	}
	
	public Long getAssesmentId() {
		return assesmentId;
	}

	public void setAssesmentId(Long assesmentId) {
		this.assesmentId = assesmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Treatment [treatmentId=" + treatmentId + ", assesmentId="
				+ assesmentId + ", name=" + name + ", fees=" + fees + "]";
	}

}
