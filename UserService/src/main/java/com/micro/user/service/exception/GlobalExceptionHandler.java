package com.micro.user.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.micro.user.service.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex)
	{
		String message=ex.getMessage();
		ApiResponse build = new ApiResponse();
		build.setMessage(message);
		build.setSuccess(true);
		build.setStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(build,HttpStatus.NOT_FOUND);
	}
}
