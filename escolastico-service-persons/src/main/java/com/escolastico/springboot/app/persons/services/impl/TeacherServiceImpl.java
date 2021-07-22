package com.escolastico.springboot.app.persons.services.impl;

import org.springframework.stereotype.Service;

import com.escolastico.springboot.app.commons.models.entity.person.Teacher;
import com.escolastico.springboot.app.commons.services.CommonServiceImpl;
import com.escolastico.springboot.app.persons.dao.TeacherDao;
import com.escolastico.springboot.app.persons.service.Interfaces.TeacherService;

@Service
public class TeacherServiceImpl extends CommonServiceImpl<Teacher,TeacherDao> implements TeacherService {

	
}
