package com.bharatonjava.ebroker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AGENTS")
public class Agent {

	private Long agentId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AGENT_ID")
	public Long getAgentId() {
		return agentId;
	}
	
	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

}
