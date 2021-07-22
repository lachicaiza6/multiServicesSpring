package com.escolastico.springboot.app.persons.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escolastico.springboot.app.commons.models.entity.course.Course;
import com.escolastico.springboot.app.commons.models.entity.person.Campus;
import com.escolastico.springboot.app.commons.services.CommonServiceImpl;
import com.escolastico.springboot.app.persons.clients.CourseFeignClient;
import com.escolastico.springboot.app.persons.dao.CampusDao;
import com.escolastico.springboot.app.persons.service.Interfaces.CampusService;

@Service
public class CampusServiceImpl extends CommonServiceImpl<Campus, CampusDao> implements CampusService{

	@Autowired
	private CourseFeignClient clientCourse;

	@Override
	public Iterable<Course> GetCoursesByCampus(Iterable<Long> ids) {
		
		return clientCourse.GetCoursesByCampus(ids);
	}

	@Override
	@Transactional
	public void deleteCampusCourseById(Long id) {
	repository.deleteCampusCourseById(id);;
		
	}
	
}
