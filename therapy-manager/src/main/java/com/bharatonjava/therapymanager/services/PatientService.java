package com.bharatonjava.therapymanager.services;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.therapymanager.dao.AddressDao;
import com.bharatonjava.therapymanager.dao.EnumDao;
import com.bharatonjava.therapymanager.dao.PatientDao;
import com.bharatonjava.therapymanager.dao.PrescriptionDao;
import com.bharatonjava.therapymanager.domain.Address;
import com.bharatonjava.therapymanager.domain.Assesment;
import com.bharatonjava.therapymanager.domain.HospitalEnum;
import com.bharatonjava.therapymanager.domain.Patient;
import com.bharatonjava.therapymanager.domain.Prescription;
import com.bharatonjava.therapymanager.domain.Sitting;
import com.bharatonjava.therapymanager.domain.Treatment;
import com.bharatonjava.therapymanager.utils.Constants;

@Service
public class PatientService {
	private static final Logger logger = LoggerFactory.getLogger(PatientService.class);
	private PatientDao patientDao;
	private AddressDao addressDao;
	private EnumDao enumDao;
	private PrescriptionDao prescriptionDao;
	
	@Autowired
	public void setPatientDao(PatientDao patientDao) {
		this.patientDao = patientDao;
	}
	
	@Autowired
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}
	
	@Autowired
	public void setEnumDao(EnumDao enumDao) {
		this.enumDao = enumDao;
	}
	
	@Autowired
	public void setPrescriptionDao(PrescriptionDao prescriptionDao) {
		this.prescriptionDao = prescriptionDao;
	}
	
	@Transactional
	public Long registerNewPatient(Patient patient){
		Long addressId = addressDao.createAddress(patient.getAddress());
		patient.getAddress().setAddressId(addressId);
		Long patientId = patientDao.createPatient(patient);
		return patientId;
	}
	
	@Transactional
	public List<HospitalEnum> getBloodGroups(){
		
		List<HospitalEnum> bloodGroups = this.enumDao.getHospitalEnumByGroup(Constants.ENUM_GROUP_BLOOD_GROUP);
		return bloodGroups;
	}
	
	@Transactional
	public Patient getPatientById(Long patientId){
		
		Patient patient = this.patientDao.getPatient(patientId);
		if(patient != null){
			Address address = this.addressDao.getAddressById(patient.getAddress().getAddressId());
			patient.setAddress(address);
		}
		return patient;
	}
	
	@Transactional
	public List<Patient> searchPatients(String query){
		
		List<Patient> patients = patientDao.searchPatients(query);
		for(Patient p : patients){
			if(p.getAddress() != null){
				p.setAddress(addressDao.getAddressById(p.getAddress().getAddressId()));
			}
		}
		logger.info("patients: {}", patients);
		return patients;
	}
	
	@Transactional
	public Prescription getPrescription(Long prescriptionId){
		Prescription prescription = prescriptionDao.getPrescriptionById(prescriptionId);
		return prescription;
	}
	
	@Transactional
	public int updatePatient(Patient patient) {
		return this.patientDao.updatePatient(patient);
	}
	
	@Transactional
	public Long createNewAssesment(Assesment assesment){
		return this.patientDao.createNewAssesment(assesment);
	}
	
	@Transactional
	public List<Assesment> getAssessmentsForPatient(Long patientId, boolean activeOnly){
		List<Assesment> assesments = this.patientDao.getAssessmentsForPatient(patientId, activeOnly);
		return assesments;
	}
	
	@Transactional
	public List<Treatment> getTreatments() {
		List<Treatment> treatments = this.prescriptionDao.getTreatments();
		return treatments;
	}
	
	@Transactional
	public Treatment getTreatment(Long treatmentId){
		return this.prescriptionDao.getTreatment(treatmentId);
	}
	
	@Transactional
	public int addNewSittingToAssessment(Long assessmentId, Long treatmentId){
		Treatment t = this.prescriptionDao.getTreatment(treatmentId);
		Sitting s = new Sitting();
		s.setAssessmentId(assessmentId);
		s.setFees(t.getFees());
		s.setTreatment(t.getName());
		s.setCreatedDate(new Date());
		int count = this.patientDao.addNewSittingToAssessment(s);
		return count;
	}
	
	@Transactional
	public List<Sitting> getSittingsForAssessment(Long assessmentId){
		return this.patientDao.getSittingsForAssessment(assessmentId);
	}
}
