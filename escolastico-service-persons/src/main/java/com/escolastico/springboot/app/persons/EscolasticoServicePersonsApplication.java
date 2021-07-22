package com.escolastico.springboot.app.persons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.escolastico.springboot.app.commons.models.entity.person",
	"com.escolastico.springboot.app.commons.models.entity.person.relations",
	"com.escolastico.springboot.app.commons.controller",
	"com.escolastico.springboot.app.commons.services",
	"com.escolastico.springboot.app.courses.clients",
	"com.escolastico.springboot.app.commons.models.entity.course",
	"com.escolastico.springboot.app.commons.SubjectSrCEnrollment",
	"com.escolastico.springboot.app.commons.PersonPayment"})
public class EscolasticoServicePersonsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscolasticoServicePersonsApplication.class, args);
	}

}
