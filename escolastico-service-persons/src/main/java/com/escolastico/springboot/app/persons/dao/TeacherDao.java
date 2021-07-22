package com.escolastico.springboot.app.persons.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.escolastico.springboot.app.commons.models.entity.person.Teacher;


public interface TeacherDao extends PagingAndSortingRepository<Teacher,Long>{

	
	
	/*  @RestResource(path= "buscar-username")
	  public Teacher findByUsername(@Param("nombre") String username);
	  
	  @Query("Select u from Usuario u where u.username=?1")
	  public Teacher obtenerPorUsername(String name);
	  */
	  
}
