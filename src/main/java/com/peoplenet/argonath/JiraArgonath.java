package com.peoplenet.argonath;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.peoplenet.argonath",
				"com.peoplenet.argonath.controller",
				"com.peoplenet.argonath.config",
				"com.peoplenet.argonath.dao",
				"com.peoplenet.argonath.model",
				"com.peoplenet.argonath.service"})
@SpringBootApplication
public class JiraArgonath extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JiraArgonath.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(JiraArgonath.class, args);
	}


}
