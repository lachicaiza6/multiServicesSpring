package com.escolastico.springboot.app.courses.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolastico.springboot.app.commons.controller.CommonController;
import com.escolastico.springboot.app.commons.models.entity.course.Department;
import com.escolastico.springboot.app.courses.services.Interfaces.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController extends CommonController<Department,DepartmentService>{

}
