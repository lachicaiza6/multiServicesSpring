package com.escolastico.springboot.app.persons.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.escolastico.springboot.app.user.commons.models.entity.User;

@FeignClient(name="service-users")
public interface UserFeignClient {
  
	//cominicar con el microservicio usuario
	@PostMapping("/create")
	public User createUser(@RequestBody User user);
		
	
}
