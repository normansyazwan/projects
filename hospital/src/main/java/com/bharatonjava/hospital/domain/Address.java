package com.bharatonjava.hospital.domain;

public class Address {

	private Long addressId;
	private Long patientId;
	private String apartment;
	private String street;
	private String area;
	private HospitalEnum city;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public HospitalEnum getCity() {
		return city;
	}

	public void setCity(HospitalEnum city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", patientId=" + patientId
				+ ", apartment=" + apartment + ", street=" + street + ", area="
				+ area + ", city=" + city + "]";
	}

}
