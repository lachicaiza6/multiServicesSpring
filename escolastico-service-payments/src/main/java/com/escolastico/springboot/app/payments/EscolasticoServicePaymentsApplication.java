package com.escolastico.springboot.app.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EntityScan({"com.escolastico.springboot.app.commons.models.entity.payment"})
@SpringBootApplication
@EnableEurekaClient
public class EscolasticoServicePaymentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscolasticoServicePaymentsApplication.class, args);
	}

}
