package com.lcwd.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@EnableEurekaClient
//@EnableConfigServer
@OpenAPIDefinition(info=@Info(title="Hotel Service API",version="3.0",description="This is the Hotel Microservice deveolped by Mutien"))

public class HotelServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HotelServiceApplication.class, args);
	}
	
}
