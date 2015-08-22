package com.bharatonjava.hospital.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bharatonjava.hospital.domain.Patient;
import com.bharatonjava.hospital.domain.Prescription;
import com.bharatonjava.hospital.utils.Constants;

@Repository
public class PatientDao implements IPatientDao {

	private static final Logger log = LoggerFactory.getLogger(PatientDao.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Override
	public Patient getPatientById(Long patientId) {

		log.info("Fetching record for patientId: {}", patientId);
		Patient patient = null;
		Session session = this.sessionFactory.getCurrentSession();
		patient = (Patient) session.get(Patient.class, patientId);
		patient.getPrescriptions().size();
		return patient;
	}

	@Override
	public List<Patient> getAllPatients() {

		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Patient");
		List<Patient> patients = query.list();
		return patients;
	}

	@Override
	public Long savePatient(final Patient patient) {

		log.info("Saving Patient: {}", patient);
		Session session = this.sessionFactory.getCurrentSession();
		Long patientId = (Long) session.save(patient);
		return patientId;
	}

	@Override
	public void updatePatient(Patient patient) {

		log.info("Updating patient: {}", patient);
		Session session = this.sessionFactory.getCurrentSession();
		// at this point patient came from jsp and does not have prescriptions
		// we will fetch prescriptions and assign to patient
		Patient p = (Patient) session
				.load(Patient.class, patient.getPersonId());
		log.info("Fetched {} prescriptions", p.getPrescriptions().size());
		session.evict(p);
		patient.setPrescriptions(p.getPrescriptions());
		session.update(patient);
	}

	@Override
	public void deletePatient(Patient patient) {

		Session session = this.sessionFactory.getCurrentSession();
		session.delete(patient);
	}

	@Override
	public void deletePatient(Long patientId) {

		Session session = this.sessionFactory.getCurrentSession();
		Patient patient = (Patient) session.get(Patient.class, patientId);
		if (patient != null) {
			log.info("Deleting Patient with Id {}", patientId);
			session.delete(patient);

		} else {
			log.info("Patient with patientId {} does not exist", patientId);
		}
	}

	@Override
	public List<Patient> searchPatients(String query) {

		List<Patient> patients = null;
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Patient.class);

		crit.add(Restrictions.or(Restrictions.or(
				Restrictions.ilike("firstName", "%" + query + "%"),
				Restrictions.ilike("lastName", "%" + query + "%")),
				Restrictions.ilike("mobile", "%" + query + "%")));

		crit.setMaxResults(Constants.MAX_SEARCH_RESULTS);
		patients = crit.list();
		return patients;
	}

	@Override
	public Long savePrescription(Prescription prescription, Long patientId) {

		Session session = this.sessionFactory.getCurrentSession();
		Patient patient = (Patient) session.get(Patient.class, patientId);
		prescription.setPatient(patient);
		Long prescriptionId = (Long) session.save(prescription);
		return prescriptionId;
	}

	@Override
	public Patient getAllPrescriptions(Long patientId) {

		Session session = this.sessionFactory.getCurrentSession();
		Patient patient = (Patient) session.get(Patient.class, patientId);
		patient.getPrescriptions().size();

		return patient;
	}

	@Override
	public Prescription getPrescription(Long prescriptionId) {

		Session session = this.sessionFactory.getCurrentSession();
		Prescription prescription = (Prescription) session.get(
				Prescription.class, prescriptionId);
		return prescription;

	}

	@Override
	public void updatePrescription(Prescription prescription) {

		Session session = this.sessionFactory.getCurrentSession();
		session.update(prescription);
	}

	@Override
	public Long totalPatientCount() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Patient.class).setProjection(
				Projections.rowCount());
		Long patientCount = (Long) crit.uniqueResult();
		return patientCount;
	}

	@Override
	public List<Object[]> getAveragePrescriptionCount(int months) {
		
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Prescription.class);
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.sqlGroupProjection(
				"date(created_timestamp) as createdTimestamp",
				"createdTimestamp", new String[] { "createdTimestamp" },
				new Type[] { StandardBasicTypes.DATE }));
		projectionList.add(Projections.rowCount());
		criteria.setProjection(projectionList);
		
		Calendar date = Calendar.getInstance();
		date.roll(Calendar.MONTH, - months);
		log.info("Rolling back {} months. Date is : {}", months, date.getTime());
		criteria.add(Restrictions.ge("createdTimestamp", date.getTime()));

		List<Object[]> results = criteria.list();
		
		for(Object[] o : results){
			log.debug("value: {} - {}", o[0], o[1]);
		}
		
		return results;
	}

}