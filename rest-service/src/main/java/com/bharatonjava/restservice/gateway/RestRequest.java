package com.bharatonjava.restservice.gateway;

import java.io.OutputStream;
import java.sql.ResultSet;
import java.util.Map;

public interface RestRequest {

	public OutputStream getOutputStream();
	
	public Map<Object, Object> getRequestMap();

	public void setResultSet(ResultSet resultSet);
	
	public ResultSet getResultSet();
}
