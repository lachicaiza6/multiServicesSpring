package com.escolastico.springboot.app.courses.services.Impl;

import org.springframework.stereotype.Service;

import com.escolastico.springboot.app.commons.models.entity.course.Schedule;
import com.escolastico.springboot.app.commons.services.CommonServiceImpl;
import com.escolastico.springboot.app.courses.models.dao.ScheduleDao;
import com.escolastico.springboot.app.courses.services.Interfaces.ScheduleService;
@Service
public class ScheduleServiceImpl extends CommonServiceImpl<Schedule,ScheduleDao> implements ScheduleService{

}
