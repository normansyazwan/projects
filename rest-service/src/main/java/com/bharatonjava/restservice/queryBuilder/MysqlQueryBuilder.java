package com.bharatonjava.restservice.queryBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bharatonjava.restservice.cache.Cache;
import com.bharatonjava.restservice.cache.Mapping;
import com.bharatonjava.restservice.cache.ObjectType;
import com.bharatonjava.restservice.gateway.RestRequest;
import com.bharatonjava.restservice.utils.Constants;

public class MysqlQueryBuilder implements QueryBuilder {

	private static final Logger log = LoggerFactory.getLogger(MysqlQueryBuilder.class);

	@Override
	public String getQueryForRequest(RestRequest request) throws Exception {

		log.info("Entering query builder.");

		// String[] arr = (String[])
		// request.getRequestMap().get(Constants.DATA_SCHEMA_VERSION);

		/*
		 * String objectNameWithVersion = request.getRequestMap().get(
		 * Constants.OBJECT_TYPE) + Constants.COLON + Integer.parseInt(arr[0]);
		 */
		String objectNameWithVersion = (String) request.getRequestMap().get(Constants.OBJECTTYPE_WITH_VERSION);
		log.info("Getting metadata for : {}", objectNameWithVersion);

		ObjectType objectType = Cache.getCache().getObject(objectNameWithVersion);

		// check if object object was present in cache
		if (objectType == null) {
			throw new Exception("Bad request: Invalid object type.");
		}

		// build query
		StringBuilder sql = new StringBuilder();
		sql.append("select ");

		for (Mapping mapping : objectType.getMappings()) {
			sql.append(mapping.getColumn() + ",");
		}

		// remove last comma
		if (sql != null && ",".equals(sql.substring(sql.length() - 1, sql.length()))) {
			sql.replace(sql.length() - 1, sql.length(), "");
		}

		sql.append(" from ");
		sql.append(objectType.getViewName());
		log.info("Final Query is: {}", sql.toString());
		return sql.toString();
	}
}
