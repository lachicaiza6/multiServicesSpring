package com.escolastico.springboot.app.courses.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolastico.springboot.app.commons.SubjectSrCEnrollment.SubjectNrcEnrollment;
import com.escolastico.springboot.app.commons.controller.CommonController;
import com.escolastico.springboot.app.commons.models.entity.course.SubjectNrc;
import com.escolastico.springboot.app.commons.models.entity.enrollment.Enrollment;
import com.escolastico.springboot.app.commons.models.entity.person.Student;
import com.escolastico.springboot.app.commons.models.entity.person.relations.StudentEnrollment;
import com.escolastico.springboot.app.courses.services.Interfaces.SubjectNrcService;

@RestController
@RequestMapping("/subjectNrc")
public class SubjectNrcController extends CommonController<SubjectNrc, SubjectNrcService>  {

	
	@GetMapping
	@Override
	public ResponseEntity<?> findAll(){
		List<SubjectNrc> subjectNrc=((List<SubjectNrc>) service.findAll()).stream()
				.map(c->{
					c.getSubjectNrcEnrollment().forEach(ca->{
						Enrollment enrollment=new Enrollment();
						enrollment.setId(ca.getIdEnrollment());
						c.addEnrollment(enrollment);
					});
					return c;
				}).collect(Collectors.toList());
		return ResponseEntity.ok().body(subjectNrc);
	}
	//asignamos una lista de cursos
		@PutMapping("/{id}/asing-enrollment")
		public ResponseEntity<?> assingnEnrollment(@RequestBody List<Enrollment> enrollment,@PathVariable Long id){
			Optional<SubjectNrc> o=this.service.findById(id);
			if(!o.isPresent()) 
				return ResponseEntity.notFound().build();
			SubjectNrc dbSubjectNrc=o.get();
			
			enrollment.forEach(a->{
				SubjectNrcEnrollment subjectNrcErollment=new SubjectNrcEnrollment();
				subjectNrcErollment.setIdEnrollment(a.getId());
				subjectNrcErollment.setSubjectNrc(dbSubjectNrc);
				dbSubjectNrc.addSubjectNrcEnrollment(subjectNrcErollment);
			});
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbSubjectNrc));	
		}
		@PutMapping("/{id}/delete-enrollment")
		public ResponseEntity<?> deleteEnrollment(@RequestBody Enrollment enrollment,@PathVariable Long id){
			Optional<SubjectNrc> o=this.service.findById(id);
			if(!o.isPresent()) 
				return ResponseEntity.notFound().build();
			SubjectNrc dbSubjectNrc=o.get();
			
				SubjectNrcEnrollment subjectNrcErollment=new SubjectNrcEnrollment();
				subjectNrcErollment.setIdEnrollment(enrollment.getId());
				dbSubjectNrc.deleteSubjectNrcEnrollment(subjectNrcErollment);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbSubjectNrc));
		}
		@GetMapping("/{id}")
		@Override
		public ResponseEntity<?> findById(@PathVariable Long id){
			Optional<SubjectNrc> o=service.findById(id);
			
			if(o.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
			SubjectNrc subjectNrc=o.get();
			if(subjectNrc.getSubjectNrcEnrollment().isEmpty()==false) {
				List<Long> ids=subjectNrc.getSubjectNrcEnrollment().stream().map(ca->ca.getIdEnrollment())
						.collect(Collectors.toList());
				List<Enrollment> enrollment=(List<Enrollment>) service.GetEnrollmentBySubjectNrc(ids);
				subjectNrc.setEnrollment(enrollment);
			}

			return ResponseEntity.ok().body(subjectNrc);
		}
		@GetMapping("/filter/{filter}")
		public ResponseEntity<?> findByNrcLike(@PathVariable String filter){
			return ResponseEntity.ok(service.findSubjectNrcByNrcLike(filter));
			
		}
		
}
