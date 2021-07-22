package com.escolastico.springboot.app.courses.services.Interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.escolastico.springboot.app.commons.models.entity.course.SubjectNrc;
import com.escolastico.springboot.app.commons.models.entity.enrollment.Enrollment;
import com.escolastico.springboot.app.commons.services.CommonService;

public interface SubjectNrcService extends CommonService<SubjectNrc> {

	public Iterable<Enrollment> GetEnrollmentBySubjectNrc(@RequestParam List<Long> ids);
	
	
	public List<SubjectNrc> findSubjectNrcByNrcLike(String nrc);
	
}
