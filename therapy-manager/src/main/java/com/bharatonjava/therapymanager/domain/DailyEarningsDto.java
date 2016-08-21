package com.bharatonjava.therapymanager.domain;

import java.util.Date;

public class DailyEarningsDto {

	private Date createdDate;
	private Double fees;

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


	@Override
	public String toString() {
		return "DailyEarningsDto [createdDate=" + createdDate + ", fees="
				+ fees + "]";
	}

}
