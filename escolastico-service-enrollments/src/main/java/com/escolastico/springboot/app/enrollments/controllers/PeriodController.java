package com.escolastico.springboot.app.enrollments.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolastico.springboot.app.commons.controller.CommonController;
import com.escolastico.springboot.app.commons.models.entity.enrollment.Period;
import com.escolastico.springboot.app.enrollments.services.PeriodService;

@RestController
@RequestMapping("/period")
public class PeriodController extends CommonController<Period,PeriodService>{

}
