package com.escolastico.springboot.app.courses.models.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.escolastico.springboot.app.commons.models.entity.course.Course;

//@RepositoryRestResource(path="courses")
public interface CourseDao extends PagingAndSortingRepository<Course, Long>{

	
	  
}
