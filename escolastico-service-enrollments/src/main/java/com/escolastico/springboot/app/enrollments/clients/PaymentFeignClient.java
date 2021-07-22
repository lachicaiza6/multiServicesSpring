package com.escolastico.springboot.app.enrollments.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;



import com.escolastico.springboot.app.commons.models.entity.payment.Payment;

@FeignClient(name="service-payments")
public interface PaymentFeignClient {
//	@GetMapping("/payment-repository/")
	@RequestMapping(method = RequestMethod.GET, value = "/payment-repository/")
	public CollectionModel<Payment>  findAll();
	

}
