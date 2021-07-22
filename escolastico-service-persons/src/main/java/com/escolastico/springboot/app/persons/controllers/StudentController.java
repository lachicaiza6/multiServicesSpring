package com.escolastico.springboot.app.persons.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolastico.springboot.app.commons.PersonPayment.StudentPayment;
import com.escolastico.springboot.app.commons.controller.CommonController;
import com.escolastico.springboot.app.commons.models.entity.course.Course;
import com.escolastico.springboot.app.commons.models.entity.enrollment.Enrollment;
import com.escolastico.springboot.app.commons.models.entity.payment.Payment;
import com.escolastico.springboot.app.commons.models.entity.person.Campus;
import com.escolastico.springboot.app.commons.models.entity.person.Student;
import com.escolastico.springboot.app.commons.models.entity.person.relations.CampusCourse;
import com.escolastico.springboot.app.commons.models.entity.person.relations.StudentEnrollment;
import com.escolastico.springboot.app.persons.service.Interfaces.StudentService;
import com.escolastico.springboot.app.user.commons.models.entity.Rol;
import com.escolastico.springboot.app.user.commons.models.entity.User;

@RestController
@RequestMapping("/student")
public class StudentController extends CommonController<Student, StudentService> {

	@GetMapping
	@Override
	public ResponseEntity<?> findAll(){
		List<Student> student=((List<Student>) service.findAll()).stream().map(c->{
			c.getStudentEnrollment().forEach(ca->{
				Enrollment enrollment=new Enrollment();
				enrollment.setId(ca.getIdEnrollment());
				c.addEnrollment(enrollment);
			});
			return c;
		}).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(student);
		
	}
	//asignamos una lista de cursos
	@PutMapping("/{id}/asing-enrollment")
	public ResponseEntity<?> assingnEnrollment(@RequestBody List<Enrollment> enrollment,@PathVariable Long id){
		Optional<Student> o=this.service.findById(id);
		if(!o.isPresent()) 
			return ResponseEntity.notFound().build();
		Student dbStudent=o.get();
		
		enrollment.forEach(a->{
			StudentEnrollment studentErollment=new StudentEnrollment();
			studentErollment.setIdEnrollment(a.getId());
			studentErollment.setStudent(dbStudent);
			dbStudent.addStudentEnrollment(studentErollment);
		});
	return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbStudent));	
	}

	
	//asignamos una lista de cursos
		@PutMapping("/{id}/delete-enrollment")
		public ResponseEntity<?> deleteEnrollment(@RequestBody Enrollment enrollment,@PathVariable Long id){
			Optional<Student> o=this.service.findById(id);
			if(!o.isPresent()) 
				return ResponseEntity.notFound().build();
			Student dbStudent=o.get();
			
				StudentEnrollment studentErollment=new StudentEnrollment();
				studentErollment.setIdEnrollment(enrollment.getId());
				dbStudent.removeStudentEnrollment(studentErollment);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbStudent));	
		}
		@GetMapping("/{id}")
		@Override
		public ResponseEntity<?> findById(@PathVariable Long id){
			Optional<Student> o=service.findById(id);
			
			if(o.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
			Student student=o.get();
			if(student.getStudentEnrollment().isEmpty()==false) {
				List<Long> ids=student.getStudentEnrollment().stream().map(ca->ca.getIdEnrollment())
						.collect(Collectors.toList());
				List<Enrollment> enrollment=(List<Enrollment>) service.GetEnrollmentByStudent(ids);
				student.setEnrollment(enrollment);
			}

			return ResponseEntity.ok().body(student);
		}
		
		@PostMapping("/create")
		public ResponseEntity<?> createStudenAndUser(@RequestBody Student student){
			
			 Student entitydb=service.save(student);
			 //name+lastname=username
			// INSERT INTO rols (name) VALUES ('ROLE_USER');
			 //INSERT INTO rols (name) VALUES ('ROLE_ADMIN');
			 User usr=new User();
			 usr.setIdStudent(entitydb.getId());
			 List<Rol> rols=new ArrayList<Rol>();
				Rol rol = new Rol();
				rol.setId(Long.valueOf(1));
				rol.setName("ROLE_USER");
				rols.add(rol);
				usr.setRoles(rols);
				usr.setUsername(entitydb.getName()+entitydb.getLastName());
			usr.setEnabled(true);
			 usr.setEmail(entitydb.getEmail());
			 usr.setPassword("$2a$10$o2M8Hj5JStENOiZUcE51LugTFUNcaMuyEinktxZ/.Y3jUjuqmy9y6");
			 //usr.setPassword(entitydb.getId().toString());
			//service.createUser(usr);
			System.out.print(service.createUser(usr));
			
			return ResponseEntity.status(HttpStatus.CREATED).body(usr);
		}
		
		@GetMapping("/{email}/email")
		public ResponseEntity<?> findStudenByEmail(@PathVariable String email){
			return ResponseEntity.ok(service.findStudentByEmail(email));
			
		}
		@GetMapping("/payment")
		public ResponseEntity<?> findAllPayment(){
			List<Student> student=((List<Student>) service.findAll()).stream().map(c->{
				c.getStudentPayment().forEach(ca->{
					Payment payment=new Payment();
					payment.setId(ca.getIdPayment());
					c.addPayment(payment);
				});
				return c;
			}).collect(Collectors.toList());
			
			return ResponseEntity.ok().body(student);
			
		}
		@GetMapping("/{id}/payment")
		public ResponseEntity<?> findByIdPayment(@PathVariable Long id){
			Optional<Student> o=service.findById(id);
			
			if(o.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
			Student student=o.get();
			if(student.getStudentPayment().isEmpty()==false) {
				List<Long> ids=student.getStudentPayment().stream().map(ca->ca.getIdPayment())
						.collect(Collectors.toList());
				List<Payment> payment=(List<Payment>) service.getPaymentByStudent(ids);
				student.setPayment(payment);
			}

			return ResponseEntity.ok().body(student);
		}
		
		
		//asignamos una lista de cursos
		@PutMapping("/{id}/asing-payment")
		public ResponseEntity<?> assingnPayment(@RequestBody List<Payment> payment,@PathVariable Long id){
			Optional<Student> o=this.service.findById(id);
			if(!o.isPresent()) 
				return ResponseEntity.notFound().build();
			Student dbStudent=o.get();
			
			payment.forEach(a->{
				StudentPayment studentPayment=new StudentPayment();
				studentPayment.setIdPayment(a.getId());
				studentPayment.setStudent(dbStudent);
				dbStudent.addStudentPayment(studentPayment);
			});
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbStudent));	
		}
		
		//eliminamos un curso
		@PutMapping("/{id}/delete-payment")
		public ResponseEntity<?> removePayment(@RequestBody Payment payment,@PathVariable Long id){
			Optional<Student> o=this.service.findById(id);
			if(!o.isPresent()) 
				return ResponseEntity.notFound().build();
			Student dbStudent=o.get();
			StudentPayment studentPayment=new StudentPayment();
			studentPayment.setIdPayment(payment.getId());
			dbStudent.removeStudentPayment(studentPayment);		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbStudent));	
		}
		
		
		
}
