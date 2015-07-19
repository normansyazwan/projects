package com.bharatonjava.hospital.dao.billing;

import java.util.List;

import com.bharatonjava.hospital.domain.BillableItem;

public interface IBillingDao {

	public List<BillableItem> getBillableItems();
	public BillableItem getBillableItem(Long itemId);
}
