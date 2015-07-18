package com.bharatonjava.hospital.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bharatonjava.hospital.domain.Address;

@Repository
public class AddressDao implements IAddressDao{

	private static final Logger log = LoggerFactory.getLogger(AddressDao.class);
	
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Long saveAddress(final Address address) {
		Session session = this.sessionFactory.getCurrentSession();
		Long addressId = (Long) session.save(address);
		return addressId;
	}

	@Override
	public Address getAddressById(Long addressId) {
		Session session = this.sessionFactory.getCurrentSession();
		Address address = (Address) session.get(Address.class, addressId);
		return address;
	}

}
