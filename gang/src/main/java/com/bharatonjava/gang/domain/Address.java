package com.bharatonjava.gang.domain;

public class Address {

	private Long userId;
	private String apartment;
	private String locality;
	private String city;
	private String state;

	public Address() {
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [userId=" + userId + ", apartment=" + apartment
				+ ", locality=" + locality + ", city=" + city + ", state="
				+ state + "]";
	}

}
