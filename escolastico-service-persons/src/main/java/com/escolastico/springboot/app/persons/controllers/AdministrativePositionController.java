package com.escolastico.springboot.app.persons.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolastico.springboot.app.commons.controller.CommonController;
import com.escolastico.springboot.app.commons.models.entity.person.AdministrativePosition;
import com.escolastico.springboot.app.persons.service.Interfaces.AdministrativePositionService;

@RestController
@RequestMapping("/Admin-pos")
public class AdministrativePositionController extends CommonController<AdministrativePosition, AdministrativePositionService>{

}
