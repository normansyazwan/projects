package com.bharatonjava.hospital.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHORITIES")
public class Authority {
	private Long authorityId;
	//private String username;
	private String authority;
	private User user;
	
	public Authority() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "authorityId")
	public Long getAuthorityId() {
		return authorityId;
	}
	
	public void setAuthorityId(Long authorityId) {
		this.authorityId = authorityId;
	}
	
	/*
	@Column(name = "USERNAME", nullable = false, unique = true)
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	*/
	
	@Column(name = "AUTHORITY", nullable = false, unique = true)
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERNAME", nullable = false)
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
