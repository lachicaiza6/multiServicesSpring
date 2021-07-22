package com.escolastico.springboot.app.courses.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="service-persons")
public interface CampusFeignClient {

	@DeleteMapping("/delete-curses/{id}")
	public void deleteCampusCourseById(@PathVariable Long id);
	
	
	
}
