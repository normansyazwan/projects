package com.bharatonjava.restservice.gateway;

public class ServiceStatus {

	private String statusCode;
	private String statusMessage;
	
	public ServiceStatus() {
	}
	
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	public String getStatusCode() {
		return statusCode;
	}
	
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	public String getStatusMessage() {
		return statusMessage;
	}
	
	
	
	public ServiceStatus(String statusCode, String statusMessage){
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

	@Override
	public String toString() {
		return "ServiceStatus [statusCode=" + statusCode + ", statusMessage="
				+ statusMessage + "]";
	}
	
	
}
