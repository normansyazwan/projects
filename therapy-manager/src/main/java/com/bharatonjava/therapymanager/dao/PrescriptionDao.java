package com.bharatonjava.therapymanager.dao;

import java.util.List;

import com.bharatonjava.therapymanager.domain.Prescription;

public interface PrescriptionDao {
	public Long savePrescription(Prescription prescription);
	public Long updatePrescription(Prescription prescription);
	public Long deletePrescription(Long prescriptionId);
	public Prescription getPrescriptionById(Long prescriptionId);
	public List<Prescription> getPrescritpions(Long patientId);
}
