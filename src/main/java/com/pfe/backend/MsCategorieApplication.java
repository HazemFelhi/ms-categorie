package com.pfe.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsCategorieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCategorieApplication.class, args);
	}

}
