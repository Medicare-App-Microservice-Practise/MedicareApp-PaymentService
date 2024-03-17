package com.medicare.paymentservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medicare.paymentservice.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {

	@Query("SELECT p from Payment p where p.customerId = :customerId and p.paymentStatus = :paymentStatus")
	public Optional<Payment> findPaymentByCustomer(@Param("customerId") Integer customerId, @Param("paymentStatus") Boolean paymentStatus );
	
}
