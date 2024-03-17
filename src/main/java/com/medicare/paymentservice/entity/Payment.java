package com.medicare.paymentservice.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer paymentId;
	
	private Integer customerId;
	
	private String paymentMethod;
	
	private Boolean paymentStatus;
	
	private BigDecimal paymentAmount;
	
	private LocalDateTime createdDateTime;
	
	private LocalDateTime updatedDateTime;
	
	@PrePersist
	protected void onCreate() {
		
		createdDateTime = LocalDateTime.now();
		updatedDateTime = LocalDateTime.now();
		paymentStatus = true;
	}
	
	@PreUpdate
	protected void onUpdate() {
		updatedDateTime = LocalDateTime.now();
	}
}
