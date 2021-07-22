package com.escolastico.springboot.app.enrollments.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolastico.springboot.app.commons.controller.CommonController;
import com.escolastico.springboot.app.commons.models.entity.enrollment.EnrollmentSchedule;
import com.escolastico.springboot.app.enrollments.services.EnrollmentScheduleService;

@RestController
@RequestMapping("/enrollmentSchedule")
public class EnrollmentScheduleController extends CommonController<EnrollmentSchedule,EnrollmentScheduleService> {

}
