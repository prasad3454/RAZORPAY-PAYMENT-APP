package com.payment.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.payment.dto.StudentOrder;
import com.payment.repository.StudentOrderRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Service
public class StudentService {
	
	@Autowired
	private StudentOrderRepository studentOrderRepository;
	
	@Value("${razorpay.key.id}")
	private String razorPayKey;
	
	@Value("${razorpay.secret.key}")
	private String razorPaySecret;
	
	private RazorpayClient client;
	
	public StudentOrder createOrder(StudentOrder studentOrder) throws Exception {
		
		JSONObject orderReq = new JSONObject();
		
		orderReq.put("amount", studentOrder.getAmount() * 100);
		orderReq.put("currency", "INR");
		orderReq.put("receipt", studentOrder.getEmail());
		
		this.client = new RazorpayClient(razorPayKey, razorPaySecret);
		
		Order razorPayOrder = client.orders.create(orderReq);
		
		studentOrder.setRazorpayOrderedId(razorPayOrder.get("id"));
		studentOrder.setOrderStatus(razorPayOrder.get("status"));
		
		studentOrderRepository.save(studentOrder);
		
		return studentOrder;
	}
}
