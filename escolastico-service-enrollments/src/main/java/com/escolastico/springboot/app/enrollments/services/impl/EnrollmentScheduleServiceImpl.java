package com.escolastico.springboot.app.enrollments.services.impl;

import org.springframework.stereotype.Service;

import com.escolastico.springboot.app.commons.models.entity.enrollment.EnrollmentSchedule;
import com.escolastico.springboot.app.commons.services.CommonServiceImpl;
import com.escolastico.springboot.app.enrollments.models.dao.EnrollmentSchedulleDao;
import com.escolastico.springboot.app.enrollments.services.EnrollmentScheduleService;

@Service
public class EnrollmentScheduleServiceImpl extends CommonServiceImpl<EnrollmentSchedule,EnrollmentSchedulleDao> implements EnrollmentScheduleService{

}
