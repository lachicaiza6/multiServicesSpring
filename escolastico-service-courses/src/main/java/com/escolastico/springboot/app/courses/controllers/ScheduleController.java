package com.escolastico.springboot.app.courses.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolastico.springboot.app.commons.controller.CommonController;
import com.escolastico.springboot.app.commons.models.entity.course.Schedule;
import com.escolastico.springboot.app.courses.services.Interfaces.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController extends CommonController<Schedule, ScheduleService> {

}
