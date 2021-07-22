package com.escolastico.springboot.app.enrollments.services;

import com.escolastico.springboot.app.commons.models.entity.enrollment.Enrollment;
import com.escolastico.springboot.app.commons.services.CommonService;

public interface EnrollmentService extends CommonService<Enrollment>{

	//gets all the courses when you pass a list of id's 
		Iterable<Enrollment> findAllById(Iterable<Long> ids);
	
}
