package com.poc.api;


import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CollegeStudentAdminApiApplication extends ResourceConfig {

	public static void main(String[] args) {
		SpringApplication.run(CollegeStudentAdminApiApplication.class, args);
	}

}
