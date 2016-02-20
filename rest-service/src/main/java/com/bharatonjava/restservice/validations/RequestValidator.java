package com.bharatonjava.restservice.validations;

import com.bharatonjava.restservice.gateway.RestRequest;
import com.bharatonjava.restservice.gateway.ServiceStatus;
import com.bharatonjava.restservice.utils.Constants;

public class RequestValidator {

	public static boolean validateObjectType(RestRequest request,
			ServiceStatus serviceStatus) {
		boolean status = true;
		if (request.getRequestMap().containsKey(Constants.OBJECT_TYPE)) {
			String objectType = (String) request.getRequestMap().get(
					Constants.OBJECT_TYPE);
			if (objectType != null && objectType.trim().length() == 0) {
				serviceStatus.setStatusCode(Constants.STATUS_400);
				serviceStatus.setStatusMessage(Constants.STATUS_400_MESSAGE
						+ "Request does not contain valid Object Type");
				status = false;
			}
		}
		return status;
	}
}
