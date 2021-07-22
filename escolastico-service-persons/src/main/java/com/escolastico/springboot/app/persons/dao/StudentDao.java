package com.escolastico.springboot.app.persons.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.escolastico.springboot.app.commons.models.entity.person.Student;

public interface StudentDao extends PagingAndSortingRepository<Student,Long>{

	@Query("select c from Student c join fetch c.studentEnrollment a where a.idEnrollment=?1")
	public Student findStudentBrStudentId(Long id);
	
	public Student findStudentByEmail(String email);
	
}
