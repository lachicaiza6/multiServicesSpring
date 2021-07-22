package com.escolastico.springboot.app.persons.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolastico.springboot.app.commons.models.entity.enrollment.Enrollment;
import com.escolastico.springboot.app.commons.models.entity.payment.Payment;
import com.escolastico.springboot.app.commons.models.entity.person.Student;
import com.escolastico.springboot.app.commons.services.CommonServiceImpl;
import com.escolastico.springboot.app.persons.clients.EnrollmentFeingClient;
import com.escolastico.springboot.app.persons.clients.PaymentFeignClient;
import com.escolastico.springboot.app.persons.clients.UserFeignClient;
import com.escolastico.springboot.app.persons.dao.StudentDao;
import com.escolastico.springboot.app.persons.service.Interfaces.StudentService;
import com.escolastico.springboot.app.user.commons.models.entity.User;

@Service
public class StudentServiceImpl extends CommonServiceImpl<Student,StudentDao> implements StudentService{

	@Autowired
	private EnrollmentFeingClient clientEnrollment;
	
	@Autowired
	private UserFeignClient clientUser;
	
	@Autowired
	private PaymentFeignClient paymentClient;
	
	@Override
	public Iterable<Enrollment> GetEnrollmentByStudent(Iterable<Long> ids) {
		return clientEnrollment.GetEnrollmentByStudent(ids);
	}


	@Override
	public User createUser(User user) {
		
		return clientUser.createUser(user);
	}


	@Override
	public Student findStudentByEmail(String email) {
		
		return repository.findStudentByEmail(email);
	}


	@Override
	public Iterable<Payment> getPaymentByStudent(List<Long> ids) {
		
     return paymentClient.getPaymentByStudent(ids);

	}

}
