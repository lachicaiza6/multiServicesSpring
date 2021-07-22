package com.escolastico.springboot.app.enrollments.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.escolastico.springboot.app.commons.models.entity.enrollment.EnrollmentSchedule;


//@RepositoryRestResource(path="enrollment-schedulles-repository")
public interface EnrollmentSchedulleDao extends PagingAndSortingRepository<EnrollmentSchedule, Long>{

}
