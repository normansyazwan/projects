package com.bharatonjava.hospital.dao.billing;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bharatonjava.hospital.domain.BillableItem;

@Repository
public class BillingDao implements IBillingDao{

	private static final Logger log = LoggerFactory.getLogger(BillingDao.class);
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<BillableItem> getBillableItems() {
		String sql = "SELECT * FROM BILLABLE_ITEMS";
		List<BillableItem> billableItems = this.jdbcTemplate.query(sql, new BillableItemMapper());
		log.info("Returning list of {} billableItems", billableItems != null ? billableItems.size() : 0);
		return billableItems;
	}
	
	
	
	
}
