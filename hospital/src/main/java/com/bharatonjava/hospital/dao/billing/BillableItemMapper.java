package com.bharatonjava.hospital.dao.billing;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.hospital.domain.BillableItem;

public class BillableItemMapper implements RowMapper<BillableItem> {

	@Override
	public BillableItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		BillableItem i = new BillableItem();
		i.setItemId(rs.getLong("ITEM_ID"));
		i.setDescription(rs.getString("description"));
		i.setCost(rs.getDouble("cost"));
		i.setComments(rs.getString("comments"));
		String enabled = rs.getString("IS_ACTIVE");
		
		if(enabled != null && enabled.equalsIgnoreCase("Y")){
			i.setEnabled(true);
		}else{
			i.setEnabled(false);
		}
		
		return i;
	}

}
