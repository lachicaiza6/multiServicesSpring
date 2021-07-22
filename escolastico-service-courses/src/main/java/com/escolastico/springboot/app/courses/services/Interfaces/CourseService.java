package com.escolastico.springboot.app.courses.services.Interfaces;


import com.escolastico.springboot.app.commons.models.entity.course.Course;
import com.escolastico.springboot.app.commons.services.CommonService;


public interface CourseService extends CommonService<Course>{

	//gets all the courses when you pass a list of id's 
	Iterable<Course> findAllById(Iterable<Long> ids);
	
	
	
	public void deleteCampusCourseById(Long id);
	
}
