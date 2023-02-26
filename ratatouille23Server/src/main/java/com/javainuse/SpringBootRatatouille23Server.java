package com.javainuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@SpringBootApplication
public class SpringBootRatatouille23Server {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRatatouille23Server.class, args);
	}
}