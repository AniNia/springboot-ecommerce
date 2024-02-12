package com.ecommerce.ecommercespringboot;
//ecommercespringboot

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EntityScan(basePackages = {"com.ecommerce.ecommercespringboot.model"})
public class EcommerceSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceSpringbootApplication.class, args);
	}

}
