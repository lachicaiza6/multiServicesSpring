package com.escolastico.springboot.app.courses.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.escolastico.springboot.app.commons.controller.CommonController;
import com.escolastico.springboot.app.commons.models.entity.course.Course;
import com.escolastico.springboot.app.commons.models.entity.course.SubjectNrc;
import com.escolastico.springboot.app.courses.services.Interfaces.CourseService;

@RestController
public class CourseController extends CommonController<Course, CourseService>{

	@GetMapping("courses-by-campus")
	public ResponseEntity<?> GetCoursesByCampus(@RequestParam List<Long> ids){
		return ResponseEntity.ok(service.findAllById(ids));
	}
	
	@PutMapping("/{id}/assing-subjectNrc")
	public ResponseEntity<?> assingSubjectNrc(@RequestBody List<SubjectNrc> subjectNrc,@PathVariable Long id){
		Optional<Course> o=this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Course dbCourse=o.get();
		subjectNrc.forEach(a->{
			dbCourse.addSubjectNrcs(a);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCourse));
	}
	@PutMapping("/{id}/delete-subjectNrc")
	public ResponseEntity<?> deleteSubjectNrc(@RequestBody SubjectNrc subjectNrc,@PathVariable Long id){
		Optional<Course> o=this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Course dbCourse=o.get();
		dbCourse.removeSubjectNrcs(subjectNrc);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCourse));
	}
	
}
