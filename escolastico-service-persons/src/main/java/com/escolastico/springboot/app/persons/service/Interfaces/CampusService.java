package com.escolastico.springboot.app.persons.service.Interfaces;


import org.springframework.web.bind.annotation.RequestParam;

import com.escolastico.springboot.app.commons.models.entity.course.Course;
import com.escolastico.springboot.app.commons.models.entity.person.Campus;
import com.escolastico.springboot.app.commons.services.CommonService;

public interface CampusService extends CommonService<Campus>{
	public Iterable<Course> GetCoursesByCampus(@RequestParam Iterable<Long> ids);

	public void deleteCampusCourseById(Long id);
	
}
