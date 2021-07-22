package com.escolastico.springboot.app.courses.services.Impl;

import org.springframework.stereotype.Service;

import com.escolastico.springboot.app.commons.models.entity.course.Subject;
import com.escolastico.springboot.app.commons.services.CommonServiceImpl;
import com.escolastico.springboot.app.courses.models.dao.SubjectDao;
import com.escolastico.springboot.app.courses.services.Interfaces.SubjectService;

@Service
public class SubjectServiceImpl extends CommonServiceImpl<Subject,SubjectDao> implements SubjectService{

}
