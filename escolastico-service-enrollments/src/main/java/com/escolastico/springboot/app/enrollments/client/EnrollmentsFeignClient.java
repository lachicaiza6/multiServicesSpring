package com.escolastico.springboot.app.enrollments.client;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="service-persons")
public interface EnrollmentsFeignClient {

	
	
	
	
}
