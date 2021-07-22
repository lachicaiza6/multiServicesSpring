package com.escolastico.springboot.app.persons;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.MediaType;

import com.escolastico.springboot.app.commons.models.entity.person.Student;
import com.escolastico.springboot.app.commons.models.entity.person.Teacher;


@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Teacher.class, Student.class);
	}
}