package com.escolastico.springboot.app.enrollments.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolastico.springboot.app.commons.controller.CommonController;
import com.escolastico.springboot.app.commons.models.entity.enrollment.Impediment;
import com.escolastico.springboot.app.enrollments.services.ImpedimentService;

@RestController
@RequestMapping("/impediment")
public class ImpedimentController extends CommonController<Impediment,ImpedimentService> {

}
