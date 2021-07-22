package com.escolastico.springboot.app.courses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EntityScan({"com.escolastico.springboot.app.commons.models.entity.course",
	"com.escolastico.springboot.app.commons.SubjectSrCEnrollment"})
@SpringBootApplication
@EnableEurekaClient
public class EscolasticoServiceCoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscolasticoServiceCoursesApplication.class, args);
	}

}
