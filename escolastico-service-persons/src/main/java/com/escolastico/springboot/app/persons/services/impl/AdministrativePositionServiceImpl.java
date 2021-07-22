package com.escolastico.springboot.app.persons.services.impl;

import org.springframework.stereotype.Service;

import com.escolastico.springboot.app.commons.models.entity.person.AdministrativePosition;
import com.escolastico.springboot.app.commons.services.CommonServiceImpl;
import com.escolastico.springboot.app.persons.dao.AdministrativePositionDao;
import com.escolastico.springboot.app.persons.service.Interfaces.AdministrativePositionService;

@Service
public class AdministrativePositionServiceImpl extends CommonServiceImpl<AdministrativePosition, AdministrativePositionDao> implements AdministrativePositionService {

}
