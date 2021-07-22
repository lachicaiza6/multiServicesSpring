package com.escolastico.springboot.app.persons.service.Interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.escolastico.springboot.app.commons.models.entity.enrollment.Enrollment;
import com.escolastico.springboot.app.commons.models.entity.payment.Payment;
import com.escolastico.springboot.app.commons.models.entity.person.Student;
import com.escolastico.springboot.app.commons.services.CommonService;
import com.escolastico.springboot.app.user.commons.models.entity.User;

public interface StudentService extends CommonService<Student>{

	public Iterable<Enrollment> GetEnrollmentByStudent(@RequestParam Iterable<Long> ids);
	
	public User createUser(@RequestBody User user);
	
	public Student findStudentByEmail(String email);
	
	public Iterable<Payment> getPaymentByStudent(@RequestParam List<Long> ids);
	
}
