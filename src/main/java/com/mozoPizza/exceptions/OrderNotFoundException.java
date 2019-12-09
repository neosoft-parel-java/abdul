package com.mozoPizza.exceptions;

public class OrderNotFoundException extends RuntimeException {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public OrderNotFoundException(String message) {
		super();
		this.message = message;
	}
	 
	 
	
}
