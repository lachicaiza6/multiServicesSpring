package com.escolastico.springboot.app.payments.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.escolastico.springboot.app.commons.controller.CommonController;
import com.escolastico.springboot.app.commons.models.entity.payment.Payment;
import com.escolastico.springboot.app.payments.services.interfaces.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController extends CommonController<Payment,PaymentService> {

	@GetMapping("payment-by-student")
	public ResponseEntity<?> getPaymentByStudent(@RequestParam List<Long> ids){
		return ResponseEntity.ok(service.findAllById(ids));
		
	}
	
	
}
