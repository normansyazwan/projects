package com.bharatonjava.therapymanager.dao;

import java.util.List;

import com.bharatonjava.therapymanager.domain.Prescription;
import com.bharatonjava.therapymanager.domain.Treatment;

public interface PrescriptionDao {
	public Long savePrescription(Prescription prescription);
	public Long updatePrescription(Prescription prescription);
	public Long deletePrescription(Long prescriptionId);
	public Prescription getPrescriptionById(Long prescriptionId);
	public List<Prescription> getPrescritpions(Long patientId);
	
	// treatment related methods
	public List<Treatment> getTreatments();
}
