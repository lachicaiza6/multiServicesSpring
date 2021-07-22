package com.escolastico.springboot.app.courses.services.Impl;

import org.springframework.stereotype.Service;

import com.escolastico.springboot.app.commons.models.entity.course.Mentoring;
import com.escolastico.springboot.app.commons.services.CommonServiceImpl;
import com.escolastico.springboot.app.courses.models.dao.MentoringDao;
import com.escolastico.springboot.app.courses.services.Interfaces.MentoringService;

@Service
public class MentoringServiceImpl extends CommonServiceImpl<Mentoring,MentoringDao> implements MentoringService{

}
