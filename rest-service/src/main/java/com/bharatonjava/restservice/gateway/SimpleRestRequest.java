package com.bharatonjava.restservice.gateway;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class SimpleRestRequest implements RestRequest {

	private OutputStream outputStream;
	private ResultSet resultSet;
	private Map<Object, Object> requestMap;

	public SimpleRestRequest(OutputStream outputStream) {
		requestMap = new HashMap<Object, Object>();
		this.outputStream = outputStream;
	}

	@Override
	public Map<Object, Object> getRequestMap() {

		return requestMap;
	}

	public OutputStream getOutputStream() {
		return outputStream;
	}

	@Override
	public String toString() {
		return "SimpleRestRequest [outputStream=" + outputStream
				+ ", requestMap=" + requestMap + "]";
	}

	@Override
	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;

	}

	@Override
	public ResultSet getResultSet() {

		return this.resultSet;
	}

}
