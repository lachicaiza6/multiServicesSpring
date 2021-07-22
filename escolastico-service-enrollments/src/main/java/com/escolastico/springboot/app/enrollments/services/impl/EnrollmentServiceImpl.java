package com.escolastico.springboot.app.enrollments.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escolastico.springboot.app.commons.models.entity.enrollment.Enrollment;
import com.escolastico.springboot.app.commons.services.CommonServiceImpl;
import com.escolastico.springboot.app.enrollments.models.dao.EnrollmentDao;
import com.escolastico.springboot.app.enrollments.services.EnrollmentService;
@Service
public class EnrollmentServiceImpl extends CommonServiceImpl<Enrollment, EnrollmentDao> implements EnrollmentService {

	@Override
	@Transactional(readOnly = true)
	public Iterable<Enrollment> findAllById(Iterable<Long> ids) {
		return repository.findAllById(ids);
	}



}
