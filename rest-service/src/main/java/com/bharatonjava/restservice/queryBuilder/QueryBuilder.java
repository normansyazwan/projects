package com.bharatonjava.restservice.queryBuilder;

import com.bharatonjava.restservice.gateway.RestRequest;

public interface QueryBuilder {

	public String getQueryForRequest(RestRequest request) throws Exception;
}
