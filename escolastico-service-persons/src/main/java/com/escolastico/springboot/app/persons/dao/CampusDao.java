package com.escolastico.springboot.app.persons.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.escolastico.springboot.app.commons.models.entity.person.Campus;

public interface CampusDao extends PagingAndSortingRepository<Campus,Long> {

	@Modifying
	@Query("delete from CampusCourse ca where ca.idCourse=?1")
	public void deleteCampusCourseById(Long id);
	
	
}
