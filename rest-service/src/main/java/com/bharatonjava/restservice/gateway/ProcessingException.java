package com.bharatonjava.restservice.gateway;

public class ProcessingException extends Exception {

	private static final long serialVersionUID = -4033106980947056414L;

	public ProcessingException() {
		super();
	}

	public ProcessingException(String message) {
		super(message);
	}

	public ProcessingException(String message, Throwable cause) {
		super(message, cause);
	}
}
