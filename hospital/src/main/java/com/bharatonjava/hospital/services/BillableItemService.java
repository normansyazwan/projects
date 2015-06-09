package com.bharatonjava.hospital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.hospital.dao.billing.IBillingDao;
import com.bharatonjava.hospital.domain.BillableItem;

@Service
public class BillableItemService {
	
	@Autowired
	private IBillingDao billingDao;
	
	public BillableItemService() {
	}
	
	public void setBillingDao(IBillingDao billingDao) {
		this.billingDao = billingDao;
	}
	
	@Transactional
	public List<BillableItem> getBillableItems(){
		return this.billingDao.getBillableItems();
	}
}
