package com.nms.nms_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NmsGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(NmsGatewayApplication.class, args);
	}
}
