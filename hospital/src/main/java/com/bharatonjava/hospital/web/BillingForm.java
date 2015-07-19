package com.bharatonjava.hospital.web;

import java.util.ArrayList;
import java.util.List;

import com.bharatonjava.hospital.domain.BillingRecord;

public class BillingForm {

	private Long patientId;
	private List<BillingRecord> billingRecords;
	
	public BillingForm() {
		billingRecords = new ArrayList<BillingRecord>();
	}
	
	public Long getPatientId() {
		return patientId;
	}
	
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	
	public List<BillingRecord> getBillingRecords() {
		return billingRecords;
	}
	
	public void setBillingRecords(List<BillingRecord> billingRecords) {
		this.billingRecords = billingRecords;
	}

}
