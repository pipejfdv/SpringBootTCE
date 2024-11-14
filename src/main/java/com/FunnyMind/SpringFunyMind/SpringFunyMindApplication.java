package com.FunnyMind.SpringFunyMind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringFunyMindApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringFunyMindApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringFunyMindApplication.class);
	}
}
