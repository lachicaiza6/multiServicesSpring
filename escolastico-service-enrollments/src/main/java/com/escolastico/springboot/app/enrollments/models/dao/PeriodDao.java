package com.escolastico.springboot.app.enrollments.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.escolastico.springboot.app.commons.models.entity.enrollment.Period;

public interface PeriodDao extends PagingAndSortingRepository<Period,Long> {

}
