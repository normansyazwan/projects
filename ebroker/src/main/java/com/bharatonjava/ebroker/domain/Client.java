package com.bharatonjava.ebroker.domain;

import javax.persistence.Table;

import javax.persistence.Entity;

@Entity
@Table(name = "CLIENTS")
public class Client {

	private Long clientId;
	private String name;
	private String email;
	private String phoneNo;
	private String mobileNo;
	private String address;
	
	
}
