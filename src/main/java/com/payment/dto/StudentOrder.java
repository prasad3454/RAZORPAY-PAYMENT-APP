package com.payment.dto;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "student_orders")
@Data
public class StudentOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	private String name;
	
	private String email;
	
	private String phno;
	
	private String course;
	
	private Integer amount;
	
	private String orderStatus;
	
	private String razorpayOrderedId;
}
