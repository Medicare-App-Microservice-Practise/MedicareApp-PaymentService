package com.medicare.paymentservice.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.medicare.paymentservice.response.PaymentResponse;

@RestControllerAdvice
public class PaymentException {

	@Autowired
	PaymentResponse response;
	
	@ExceptionHandler(NotSaveException.class)
	public ResponseEntity<Object> notSaveException(NotSaveException ex){
		
		return response.errorResponse("error", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> notFoundException(NotFoundException ex)
	{
		return response.errorResponse("error", ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
