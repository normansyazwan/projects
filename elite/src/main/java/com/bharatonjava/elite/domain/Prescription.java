package com.bharatonjava.elite.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PRESCRIPTION")
public class Prescription {
	
	private Long prescriptionId;
	private Long patientId;
	private String comments;
}
