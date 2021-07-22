package com.escolastico.springboot.app.courses.services.Impl;

import org.springframework.stereotype.Service;

import com.escolastico.springboot.app.commons.models.entity.course.Career;
import com.escolastico.springboot.app.commons.services.CommonServiceImpl;
import com.escolastico.springboot.app.courses.models.dao.CareerDao;
import com.escolastico.springboot.app.courses.services.Interfaces.CareerService;
@Service
public class CareerServiceImpl extends CommonServiceImpl<Career,CareerDao> implements CareerService{

}
