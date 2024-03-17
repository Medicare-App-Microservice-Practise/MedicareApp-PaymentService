package com.medicare.paymentservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponseDto {

	private Integer paymentId;
	
	private Integer customerId;
	
	private String paymentMethod;
	
	private String paymentStatus;
	
	private BigDecimal paymentAmount;
	
}
