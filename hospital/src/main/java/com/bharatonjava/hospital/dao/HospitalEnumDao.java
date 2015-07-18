package com.bharatonjava.hospital.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bharatonjava.hospital.domain.HospitalEnum;

@Repository
public class HospitalEnumDao implements IHospitalEnumDao {

	private static final Logger log = LoggerFactory.getLogger(AddressDao.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public HospitalEnum getEnumById(Long enumId) {
		
		HospitalEnum hospitalEnum = null;
		Session session = this.sessionFactory.getCurrentSession();
		hospitalEnum = (HospitalEnum) session.get(HospitalEnum.class, enumId);
		return hospitalEnum;
	}

	@Override
	public List<HospitalEnum> getEnumsByGroup(String enumGroup) {

		List<HospitalEnum> enums = null;
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(HospitalEnum.class);
		criteria.add(Restrictions.ilike("enumGroup", enumGroup));
		enums = criteria.list();
		log.info("fetched {} enums for enum_group {} ",
				enums != null ? enums.size() : 0, enumGroup);
		return enums;

	}

}
