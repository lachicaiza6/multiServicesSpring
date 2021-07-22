package com.escolastico.springboot.app.persons.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.escolastico.springboot.app.commons.models.entity.course.Course;

@FeignClient(name="service-courses")
public interface CourseFeignClient {
	
	//se comunica con miicroservicio courses
	@GetMapping("courses-by-campus")
	public Iterable<Course> GetCoursesByCampus(@RequestParam Iterable<Long> ids);
	
}
