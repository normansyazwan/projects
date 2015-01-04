package com.bharatonjava.ebroker.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class City {
	
	private Long cityId;
	private String name;
	
	public City() {
	}
	
	public City(Long cityId, String name) {
		super();
		this.cityId = cityId;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CITY_ID")
	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	@Column(name = "CITY_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
