package com.escolastico.springboot.app.enrollments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@EntityScan({"com.escolastico.springboot.app.commons.models.entity.enrollment"})
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class EscolasticoServiceEnrollmentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscolasticoServiceEnrollmentsApplication.class, args);
	}

}
