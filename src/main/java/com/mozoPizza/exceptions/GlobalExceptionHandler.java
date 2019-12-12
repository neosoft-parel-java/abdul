package com.mozoPizza.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<BadCredentialsResponseDto> handlBadCredException(BadCredentialsException exception) {
		logger.info(exception.getMessage(), exception);

		BadCredentialsResponseDto dto = new BadCredentialsResponseDto(exception.getMessage());

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(dto);
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<BadRequestDto> handlBadRequestException(BadRequestException exception) {
		logger.info(exception.getMessage(), exception);

		BadRequestDto dto = new BadRequestDto("The provided data contains invalid values");

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
	}

	@ExceptionHandler({ RuntimeException.class, Exception.class })
	public ResponseEntity<ErrorResponseDto> handleException(Exception exception) {
		logger.error(exception.getMessage(), exception);

		ErrorResponseDto dto = new ErrorResponseDto("Something went wrong");

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dto);
	}
}
