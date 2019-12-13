package com.mozoPizza.exceptions;

public class ErrorResponseDto {

	private String message;

	public ErrorResponseDto() {

	}

	public ErrorResponseDto(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
