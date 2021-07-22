package com.escolastico.springboot.app.users.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolastico.springboot.app.commons.controller.CommonController;
import com.escolastico.springboot.app.user.commons.models.entity.User;
import com.escolastico.springboot.app.users.interfaces.UserService;

@RestController
public class UserController extends CommonController<User, UserService> {

	@PostMapping("/create")
	public ResponseEntity<?> createUser(@RequestBody User user){
		
		 User us=service.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(us);
	}
	
}
