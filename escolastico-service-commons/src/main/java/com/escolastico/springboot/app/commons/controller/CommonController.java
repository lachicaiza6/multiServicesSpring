package com.escolastico.springboot.app.commons.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.escolastico.springboot.app.commons.services.CommonService;

public class CommonController<E,S extends CommonService<E>> {

	@Autowired
	protected S service;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok().body(service.findAll());
		
	}
	@GetMapping("/page")
	public ResponseEntity<?> findAll(Pageable pageable){
		return ResponseEntity.ok().body(service.findAll(pageable));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<E> entity=service.findById(id);
		
		if(entity.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(entity.get());
	}
	@PostMapping("/")
	public ResponseEntity<?> create(@RequestBody E entity){
		
		 E entitydb=service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entitydb);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
}
