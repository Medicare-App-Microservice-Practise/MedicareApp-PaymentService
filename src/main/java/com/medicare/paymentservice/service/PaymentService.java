package com.medicare.paymentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.paymentservice.dto.PaymentRequestDto;
import com.medicare.paymentservice.dto.PaymentResponseDto;
import com.medicare.paymentservice.entity.Payment;
import com.medicare.paymentservice.exception.NotFoundException;
import com.medicare.paymentservice.exception.NotSaveException;
import com.medicare.paymentservice.mapper.PaymentMapper;
import com.medicare.paymentservice.repository.PaymentRepository;
import com.medicare.paymentservice.response.PaymentResponse;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository repo;
	
	@Autowired
	PaymentMapper mapper;
	
	public Boolean addToPayment (PaymentRequestDto paymentRequestDto) throws NotSaveException
	{
		
		Payment payment = mapper.paymentRequestToPayment(paymentRequestDto);
		if(repo.save(payment) != null) {
			return true;
		}else {
			throw new NotSaveException("Unable to Save");
		}
	}
	
	public PaymentResponseDto getPaymentByCustomerId (int id) throws NotFoundException
	{
		Payment payment = repo.findPaymentByCustomer(id, true).orElseThrow(()-> new NotFoundException("Payment with ID "+id+" not Found"));
		PaymentResponseDto paymentResponseDto = mapper.paymentToPaymentResponseDto(payment);
		return paymentResponseDto;
	}

}
