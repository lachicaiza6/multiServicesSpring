package com.escolastico.springboot.app.enrollments.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.escolastico.springboot.app.commons.models.entity.enrollment.Enrollment;

//@RepositoryRestResource(path="enrollments-repository")
public interface EnrollmentDao extends PagingAndSortingRepository<Enrollment, Long>{
	
	
}
