package com.bharatonjava.hospital.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bharatonjava.hospital.domain.Patient;

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
				Restrictions.ilike("mobile", "%"+query+"%")));

		patients = crit.list();
		return patients;
	}

}
