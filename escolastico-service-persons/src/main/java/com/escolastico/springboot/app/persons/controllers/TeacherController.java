package com.escolastico.springboot.app.persons.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolastico.springboot.app.commons.controller.CommonController;
import com.escolastico.springboot.app.commons.models.entity.person.Teacher;
import com.escolastico.springboot.app.persons.service.Interfaces.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController extends CommonController<Teacher, TeacherService>{

	
}
