package com.formation.velo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2; 

@SpringBootApplication
// @EnableConfigurationProperties
@EnableScheduling
@EnableSwagger2

public class VeloApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeloApplication.class, args);
	}

}
