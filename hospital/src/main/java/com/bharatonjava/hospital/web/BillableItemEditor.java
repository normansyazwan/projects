package com.bharatonjava.hospital.web;

import java.beans.PropertyEditorSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.hospital.dao.billing.IBillingDao;
import com.bharatonjava.hospital.domain.BillableItem;
import com.bharatonjava.hospital.utils.SpringApplicationContext;


public class BillableItemEditor extends PropertyEditorSupport {

	private static final Logger log = LoggerFactory.getLogger(BillableItemEditor.class);
	private IBillingDao billingDao;
	
	public BillableItemEditor() {
		log.info("Inside BillingItemEditor");
		billingDao = (IBillingDao) SpringApplicationContext.getApplicationContext().getBean("billingDao");
	}
	
	@Autowired
	public void setBillingDao(IBillingDao billingDao) {
		this.billingDao = billingDao;
	}
	
	@Override
	@Transactional
	public void setAsText(String id) {
		BillableItem billableItem = this.billingDao.getBillableItem(Long.parseLong(id));
		this.setValue(billableItem);
	}

}
