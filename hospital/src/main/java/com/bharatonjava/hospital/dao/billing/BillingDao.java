package com.bharatonjava.hospital.dao.billing;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bharatonjava.hospital.domain.BillableItem;

@Repository
public class BillingDao implements IBillingDao{

	private static final Logger log = LoggerFactory.getLogger(BillingDao.class);
	
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<BillableItem> getBillableItems() {
		Session session = this.sessionFactory.getCurrentSession();
		List<BillableItem> billableItems = session.createQuery("from BillableItem").list();
		log.info("Returning list of {} billableItems", billableItems != null ? billableItems.size() : 0);
		return billableItems;
	}
	
	
	@Override
	public BillableItem getBillableItem(Long itemId){
		BillableItem billableItem = null;
		Session session = this.sessionFactory.getCurrentSession();
		billableItem = (BillableItem) session.get(BillableItem.class, itemId);
		return billableItem;
	}
	
	
	
}
