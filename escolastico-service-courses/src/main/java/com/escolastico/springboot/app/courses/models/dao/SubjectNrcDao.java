package com.escolastico.springboot.app.courses.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.escolastico.springboot.app.commons.models.entity.course.SubjectNrc;

public interface SubjectNrcDao extends PagingAndSortingRepository<SubjectNrc,Long> {

	@Query("select n from SubjectNrc n where n.nrc like %?1%")
	public List<SubjectNrc> findSubjectNrcByNrcLike(String nrc);
	
	
	
}
