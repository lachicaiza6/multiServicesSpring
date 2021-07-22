package com.escolastico.springboot.app.courses.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.escolastico.springboot.app.commons.models.entity.course.Subject;

public interface SubjectDao extends PagingAndSortingRepository<Subject,Long> {

}
