package com.bharatonjava.restservice.cache;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class CacheResultsetExtractor implements
		ResultSetExtractor<List<ObjectType>> {

	private static final Logger log = LoggerFactory
			.getLogger(CacheResultsetExtractor.class);

	@Override
	public List<ObjectType> extractData(ResultSet rs) throws SQLException,
			DataAccessException {

		List<ObjectType> objectTypes = new ArrayList<ObjectType>();

		ObjectType objectType = null;

		while (rs.next()) {

			if (objectType == null) {

				objectType = new ObjectType();
				
				objectType.setObjectType(rs.getString("objecttype"));
				objectType.setSchemaVersion(rs.getInt("version"));
				objectType.setViewName(rs.getString("view_name"));
			}
			
			
			if (objectType.getObjectType() != null
					&& objectType.getObjectType().equals(
							rs.getString("objecttype"))
					&& objectType.getSchemaVersion() != 0
					&& objectType.getSchemaVersion() == rs.getInt("version")) {

				Mapping m = new Mapping();
				m.setColumn(rs.getString("column_name"));
				m.setAlias(rs.getString("column_alias"));
				m.setField(rs.getString("field"));

				objectType.getMappings().add(m);

			}

			if (objectType.getObjectType() != null
					&& !objectType.getObjectType().equals(
							rs.getString("objecttype"))
					|| (objectType.getSchemaVersion() != 0 && objectType
							.getSchemaVersion() != rs.getInt("version"))
					|| rs.isLast()) {

				objectTypes.add(objectType);
				
				objectType  = null;
				
			}

		}

		log.info("objectTypes: {}", objectTypes);

		return objectTypes;
	}

}
