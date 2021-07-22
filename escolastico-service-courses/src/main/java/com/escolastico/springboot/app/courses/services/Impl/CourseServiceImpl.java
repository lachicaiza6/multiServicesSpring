package com.escolastico.springboot.app.courses.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escolastico.springboot.app.commons.models.entity.course.Course;
import com.escolastico.springboot.app.commons.services.CommonServiceImpl;
import com.escolastico.springboot.app.courses.clients.CampusFeignClient;
import com.escolastico.springboot.app.courses.models.dao.CourseDao;
import com.escolastico.springboot.app.courses.services.Interfaces.CourseService;

@Service 
public class CourseServiceImpl extends CommonServiceImpl<Course,CourseDao> implements CourseService{

	@Autowired
	private CampusFeignClient clientCampus;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Course> findAllById(Iterable<Long> ids) {
		
		return repository.findAllById(ids);
	}

	@Override
	public void deleteCampusCourseById(Long id) {
		clientCampus.deleteCampusCourseById(id);

	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		super.deleteById(id);
		this.deleteCampusCourseById(id);
	}
	
	

}
