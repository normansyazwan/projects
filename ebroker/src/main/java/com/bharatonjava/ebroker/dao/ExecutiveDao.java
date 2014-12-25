package com.bharatonjava.ebroker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bharatonjava.ebroker.domain.Executive;

@Repository
public class ExecutiveDao implements IExecutiveDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int saveExecutive(Executive executive) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(executive);
		return 0;
	}

	@Override
	public int updateExecutive(Executive executive) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Executive> getAllExecutives() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Executive> executives = session.createQuery("from Executive").list();
		return executives;
	}

	@Override
	public Executive getExecutiveById(Long executiveId) {
		// TODO Auto-generated method stub
		return null;
	}

}
