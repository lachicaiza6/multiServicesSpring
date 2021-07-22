package com.escolastico.springboot.app.persons.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolastico.springboot.app.commons.controller.CommonController;
import com.escolastico.springboot.app.commons.models.entity.course.Course;
import com.escolastico.springboot.app.commons.models.entity.person.Campus;
import com.escolastico.springboot.app.commons.models.entity.person.relations.CampusCourse;
import com.escolastico.springboot.app.persons.service.Interfaces.CampusService;

@RestController
@RequestMapping("/campus")
public class CampusController extends CommonController<Campus, CampusService>{

	//obtenemos los campus con los cursos integrados
	@GetMapping
	@Override
	public ResponseEntity<?> findAll(){
		List<Campus> campus=((List<Campus>) service.findAll()).stream().map(c->{
			c.getCampusCourse().forEach(ca->{
				Course course=new Course();
				course.setId(ca.getIdCourse());
				c.addCourse(course);
			});
			return c;
		}).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(campus);
		
	}
	//asignamos una lista de cursos
	@PutMapping("/{id}/asing-course")
	public ResponseEntity<?> assingnCourse(@RequestBody List<Course> course,@PathVariable Long id){
		Optional<Campus> o=this.service.findById(id);
		if(!o.isPresent()) 
			return ResponseEntity.notFound().build();
		Campus dbCampus=o.get();
		
		course.forEach(a->{
			CampusCourse campusCourse=new CampusCourse();
			campusCourse.setIdCourse(a.getId());
			campusCourse.setCampus(dbCampus);
			dbCampus.addCampusCourse(campusCourse);
		});
	return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCampus));	
	}
	
	//eliminamos un curso
	@PutMapping("/{id}/delete-course")
	public ResponseEntity<?> deleteCourse(@RequestBody Course course,@PathVariable Long id){
		Optional<Campus> o=this.service.findById(id);
		if(!o.isPresent()) 
			return ResponseEntity.notFound().build();
		Campus dbCampus=o.get();
		CampusCourse campusCourse=new CampusCourse();
		campusCourse.setIdCourse(course.getId());
		dbCampus.removeCampusCourse(campusCourse);
		
	return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCampus));	
	}
	
	@GetMapping("/{id}")
	@Override
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Campus> o=service.findById(id);
		
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Campus campus=o.get();
		if(campus.getCampusCourse().isEmpty()==false) {
			List<Long> ids=campus.getCampusCourse().stream().map(ca->ca.getIdCourse()).collect(Collectors.toList());
			List<Course> course=(List<Course>) service.GetCoursesByCampus(ids);
			campus.setCourse(course);
		}

		return ResponseEntity.ok().body(campus);
	}
	@GetMapping("/page")
	@Override
	public ResponseEntity<?> findAll(Pageable pageable){
		Page<Campus> campus= service.findAll(pageable).map(camp->{
			camp.getCampusCourse().forEach(ca->{
				Course course=new Course();
				course.setId(ca.getIdCourse());
				camp.addCourse(course);
			});
			return camp;
		});
		return ResponseEntity.ok().body(campus);
		
	}

	@DeleteMapping("/delete-curses/{id}")
	public ResponseEntity<?> deleteCampusCourseById(@PathVariable Long id){
		service.deleteCampusCourseById(id);;
		return ResponseEntity.noContent().build();
	}
	
	
}
