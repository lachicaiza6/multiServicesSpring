package com.escolastico.springboot.app.enrollments.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.escolastico.springboot.app.commons.controller.CommonController;
import com.escolastico.springboot.app.commons.models.entity.enrollment.Enrollment;
import com.escolastico.springboot.app.enrollments.services.EnrollmentService;

@RestController
//@RequestMapping("/enrollment")
public class EnrollmentController extends CommonController<Enrollment,EnrollmentService > {

	@GetMapping("/enrollment-by-student")
	public ResponseEntity<?> GetEnrollmentByStudent(@RequestParam List<Long> ids){
		return ResponseEntity.ok(service.findAllById(ids));
	}
	
	@GetMapping("/enrollment-by-SubjectNrc")
	public ResponseEntity<?> GetEnrollmentBySubjectNrc(@RequestParam List<Long> ids){
		return ResponseEntity.ok(service.findAllById(ids));
	}

	
}
