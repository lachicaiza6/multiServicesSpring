package com.escolastico.springboot.app.enrollments.services.impl;

import org.springframework.stereotype.Service;

import com.escolastico.springboot.app.commons.models.entity.enrollment.Period;
import com.escolastico.springboot.app.commons.services.CommonServiceImpl;
import com.escolastico.springboot.app.enrollments.models.dao.PeriodDao;
import com.escolastico.springboot.app.enrollments.services.PeriodService;

@Service
public class PeriodServiceImpl extends CommonServiceImpl<Period,PeriodDao> implements PeriodService {

}
