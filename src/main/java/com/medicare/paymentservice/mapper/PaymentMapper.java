package com.medicare.paymentservice.mapper;

import org.mapstruct.Mapper;

import com.medicare.paymentservice.dto.PaymentRequestDto;
import com.medicare.paymentservice.dto.PaymentResponseDto;
import com.medicare.paymentservice.entity.Payment;

@Mapper(componentModel="spring")
public interface PaymentMapper {

	public Payment paymentRequestToPayment(PaymentRequestDto paymentRequestDto);
	
	public PaymentResponseDto paymentToPaymentResponseDto (Payment payment);
}
