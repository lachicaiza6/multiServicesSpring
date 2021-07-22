package com.escolastico.springboot.app.enrollments.services.impl;

import org.springframework.stereotype.Service;

import com.escolastico.springboot.app.commons.models.entity.enrollment.Impediment;
import com.escolastico.springboot.app.commons.services.CommonServiceImpl;
import com.escolastico.springboot.app.enrollments.models.dao.ImpedimentDao;
import com.escolastico.springboot.app.enrollments.services.ImpedimentService;

@Service
public class ImpedimentServiceImpl extends CommonServiceImpl<Impediment,ImpedimentDao> implements ImpedimentService{
 
}
