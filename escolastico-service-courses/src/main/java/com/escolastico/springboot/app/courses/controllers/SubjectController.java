package com.escolastico.springboot.app.courses.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolastico.springboot.app.commons.controller.CommonController;
import com.escolastico.springboot.app.commons.models.entity.course.Course;
import com.escolastico.springboot.app.commons.models.entity.course.Subject;
import com.escolastico.springboot.app.commons.models.entity.course.SubjectNrc;
import com.escolastico.springboot.app.courses.services.Interfaces.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController extends CommonController<Subject,SubjectService> {

	@PutMapping("/{id}/assing-subject")
	public ResponseEntity<?> assingSubject(@RequestBody List<SubjectNrc> subjectNrc,@PathVariable Long id){
		Optional<Subject> o=this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Subject dbSubject=o.get();
		subjectNrc.forEach(a->{
			dbSubject.addSubjectNrcs(a);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbSubject));
	}
	@PutMapping("/{id}/delete-subjectNrc")
	public ResponseEntity<?> deleteSubject(@RequestBody SubjectNrc subjectNrc,@PathVariable Long id){
		Optional<Subject> o=this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Subject dbSubject=o.get();
		dbSubject.removeSubject(subjectNrc);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbSubject));
	}
	
}
