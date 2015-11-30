package com.bharatonjava.hospital.domain;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "authorities", uniqueConstraints={@UniqueConstraint(columnNames = {"USERNAME","AUTHORITY"})})
public class Authority {

	private AuthorityId authorityId;
	
	public Authority() {
		authorityId = new AuthorityId();
	}
	
	@EmbeddedId
	public AuthorityId getAuthorityId() {
		return authorityId;
	}
	
	public void setAuthorityId(AuthorityId authorityId) {
		this.authorityId = authorityId;
	}
	
	@Transient
	public String getUsername() {
		return this.authorityId.getUsername();
	}
	
	public void setUsername(String username) {
		this.authorityId.setUsername(username);
	}
	
	@Transient
	public String getAuthority() {
		return this.authorityId.getAuthority();
	}
	
	public void setAuthority(String authority) {
		this.authorityId.setAuthority(authority);
	}


}
