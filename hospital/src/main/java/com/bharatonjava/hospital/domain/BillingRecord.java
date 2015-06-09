package com.bharatonjava.hospital.domain;

public class BillingRecord {
	
	private Long recordId;
	private BillableItem billableItem;
	private int quantity;
	
	public BillingRecord() {
	}

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public BillableItem getBillableItem() {
		return billableItem;
	}

	public void setBillableItem(BillableItem billableItem) {
		this.billableItem = billableItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "BillingRecord [recordId=" + recordId + ", billableItem="
				+ billableItem + ", quantity=" + quantity + "]";
	}
	
}
