package com.escolastico.springboot.app.courses.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escolastico.springboot.app.commons.models.entity.course.SubjectNrc;
import com.escolastico.springboot.app.commons.models.entity.enrollment.Enrollment;
import com.escolastico.springboot.app.commons.services.CommonServiceImpl;
import com.escolastico.springboot.app.courses.clients.EnrollmentFeingClients;
import com.escolastico.springboot.app.courses.models.dao.SubjectNrcDao;
import com.escolastico.springboot.app.courses.services.Interfaces.SubjectNrcService;
@Service
public class SubjectNrcImpl extends CommonServiceImpl<SubjectNrc,SubjectNrcDao> implements SubjectNrcService{

	@Autowired
	private EnrollmentFeingClients clientEnrolment;
	
	
	@Override
	public Iterable<Enrollment> GetEnrollmentBySubjectNrc(List<Long> ids) {
		
		return clientEnrolment.GetEnrollmentBySubjectNrc(ids);
	}


	@Override
	@Transactional(readOnly = true)
	public List<SubjectNrc> findSubjectNrcByNrcLike(String nrc) {
		
		return repository.findSubjectNrcByNrcLike(nrc);
	}

	
}
