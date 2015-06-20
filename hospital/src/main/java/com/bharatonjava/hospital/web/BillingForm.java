package com.bharatonjava.hospital.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bharatonjava.hospital.domain.BillingRecord;

public class BillingForm {

	private List<BillingRecord> billingRecords;
	
	public BillingForm() {
		billingRecords = new ArrayList<BillingRecord>();
	}
	
	public List<BillingRecord> getBillingRecords() {
		return billingRecords;
	}
	
	public void setBillingRecords(List<BillingRecord> billingRecords) {
		this.billingRecords = billingRecords;
	}

	
}
