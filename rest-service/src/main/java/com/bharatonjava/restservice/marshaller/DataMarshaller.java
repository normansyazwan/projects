package com.bharatonjava.restservice.marshaller;

import com.bharatonjava.restservice.gateway.ProcessingException;
import com.bharatonjava.restservice.gateway.RestRequest;

public interface DataMarshaller {

	public void writeData(RestRequest request) throws ProcessingException;
	
}
