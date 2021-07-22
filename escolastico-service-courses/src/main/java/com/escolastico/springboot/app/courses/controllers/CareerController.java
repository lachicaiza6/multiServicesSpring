package com.escolastico.springboot.app.courses.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolastico.springboot.app.commons.controller.CommonController;
import com.escolastico.springboot.app.commons.models.entity.course.Career;
import com.escolastico.springboot.app.courses.services.Interfaces.CareerService;

@RestController
@RequestMapping("/career")
public class CareerController extends CommonController<Career,CareerService> {

}
