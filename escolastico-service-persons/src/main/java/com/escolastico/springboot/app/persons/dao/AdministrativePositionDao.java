package com.escolastico.springboot.app.persons.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.escolastico.springboot.app.commons.models.entity.person.AdministrativePosition;

public interface AdministrativePositionDao extends PagingAndSortingRepository<AdministrativePosition,Long> {

}
