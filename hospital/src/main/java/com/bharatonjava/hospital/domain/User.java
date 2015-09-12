package com.bharatonjava.hospital.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

	private String username;
	private String password;
	private int enabled;
	private List<Authority> authorities = new ArrayList<Authority>();
	
	public User() {
	}

	@Id
	@Column(name = "USERNAME", nullable = false, unique = true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "ENABLED", nullable = false)
	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	public List<Authority> getAuthorities() {
		return authorities;
	}
	
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
}
