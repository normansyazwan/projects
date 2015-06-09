package com.bharatonjava.hospital.domain;

public class BillableItem {

	private Long itemId;
	private String description;
	private double cost;
	private String comments;
	private boolean isEnabled;
	
	public BillableItem() {
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Override
	public String toString() {
		return "BillableItem [itemId=" + itemId + ", description="
				+ description + ", cost=" + cost + ", comments=" + comments
				+ ", isEnabled=" + isEnabled + "]";
	}
	
}
