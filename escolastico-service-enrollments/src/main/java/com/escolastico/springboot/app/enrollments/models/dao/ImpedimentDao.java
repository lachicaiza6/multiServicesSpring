package com.escolastico.springboot.app.enrollments.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.escolastico.springboot.app.commons.models.entity.enrollment.Impediment;

public interface ImpedimentDao extends PagingAndSortingRepository<Impediment,Long> {

}
