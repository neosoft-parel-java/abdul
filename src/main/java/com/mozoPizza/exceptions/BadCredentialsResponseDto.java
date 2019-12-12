package com.mozoPizza.exceptions;

public class BadCredentialsResponseDto {

	private String message;

	public BadCredentialsResponseDto() {

	}

	public BadCredentialsResponseDto(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
