package com.injecaoDependencias.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* @SpringBootApplication(
		scanBasePackages = {"com.injecoaoDependencias.springcoredemo",
		"com.injecoaoDependencias.util"}
) */
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
		System.out.println("Server running :)");
	}

}
