package com.medicare.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.paymentservice.dto.PaymentRequestDto;
import com.medicare.paymentservice.dto.PaymentResponseDto;
import com.medicare.paymentservice.exception.NotFoundException;
import com.medicare.paymentservice.exception.NotSaveException;
import com.medicare.paymentservice.response.PaymentResponse;
import com.medicare.paymentservice.service.PaymentService;

@RestController
@RequestMapping("/api/v1/payment")
@CrossOrigin
public class PaymentController {

	@Autowired
	PaymentResponse response;
	
	@Autowired
	PaymentService service;
	
	@PostMapping("")
	public ResponseEntity<Object> addToPayment (@RequestBody PaymentRequestDto paymentRequestDto) throws NotSaveException
	{
		service.addToPayment(paymentRequestDto);
		return response.responseWithoutData("success", HttpStatus.CREATED);
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Object> addToPayment (@PathVariable int customerId) throws NotSaveException, NotFoundException
	{
		PaymentResponseDto paymentResponseDto = service.getPaymentByCustomerId(customerId);
		return response.responseWithData("success", paymentResponseDto, HttpStatus.CREATED);
	}
	
}
