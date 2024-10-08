package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.dto.StudentOrder;

public interface StudentOrderRepository extends JpaRepository<StudentOrder, Integer>{
	
	public StudentOrder findByRazorpayOrderId(String orderId);
}
