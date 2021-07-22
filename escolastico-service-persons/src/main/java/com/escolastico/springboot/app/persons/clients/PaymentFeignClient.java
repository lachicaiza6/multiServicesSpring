package com.escolastico.springboot.app.persons.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.escolastico.springboot.app.commons.models.entity.payment.Payment;

@FeignClient("service-payments")
public interface PaymentFeignClient {

	//se comunica con payment-services
	@GetMapping("payment-by-student")
	public Iterable<Payment> getPaymentByStudent(@RequestParam List<Long> ids);
	
	

}
