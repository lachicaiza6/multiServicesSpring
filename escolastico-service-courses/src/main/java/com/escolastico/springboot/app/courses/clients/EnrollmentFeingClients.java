package com.escolastico.springboot.app.courses.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.escolastico.springboot.app.commons.models.entity.enrollment.Enrollment;

@FeignClient(name="service-enrollments")
public interface EnrollmentFeingClients {

	//se comunica con el microservicio enrrolment
	@GetMapping("/enrollment-by-SubjectNrc")
	public Iterable<Enrollment> GetEnrollmentBySubjectNrc(@RequestParam List<Long> ids);

}
