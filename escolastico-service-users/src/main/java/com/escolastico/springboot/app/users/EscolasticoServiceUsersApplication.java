package com.escolastico.springboot.app.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EntityScan({"com.escolastico.springboot.app.user.commons.models.entity"})
@SpringBootApplication
@EnableEurekaClient
public class EscolasticoServiceUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscolasticoServiceUsersApplication.class, args);
	}

}
