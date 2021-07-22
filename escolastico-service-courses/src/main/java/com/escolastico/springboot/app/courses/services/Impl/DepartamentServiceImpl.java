package com.escolastico.springboot.app.courses.services.Impl;

import org.springframework.stereotype.Service;

import com.escolastico.springboot.app.commons.models.entity.course.Department;
import com.escolastico.springboot.app.commons.services.CommonServiceImpl;
import com.escolastico.springboot.app.courses.models.dao.DepartmentDao;
import com.escolastico.springboot.app.courses.services.Interfaces.DepartmentService;

@Service
public class DepartamentServiceImpl extends CommonServiceImpl<Department,DepartmentDao> implements DepartmentService {

}
