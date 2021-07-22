package com.escolastico.springboot.app.courses.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolastico.springboot.app.commons.controller.CommonController;
import com.escolastico.springboot.app.commons.models.entity.course.Mentoring;
import com.escolastico.springboot.app.courses.services.Interfaces.MentoringService;

@RestController
@RequestMapping("/mentoring")
public class MentoringController extends CommonController<Mentoring,MentoringService> {

}
