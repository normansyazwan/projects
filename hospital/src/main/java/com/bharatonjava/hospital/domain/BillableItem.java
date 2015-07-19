package com.bharatonjava.hospital.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BILLABLE_ITEM")
public class BillableItem {

	private Long itemId;
	private String itemName;
	private String description;
	private double cost;
	private String comments;
	private boolean isEnabled;
	
	public BillableItem() {
	}
 
	@Id
	@Column(name = "BILLABLE_ITEM_ID")
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
	@Column(name = "ITEM_NAME")
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "COST")
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Column(name = "COMMENTS")
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name = "ENABLED")
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
