package com.jason.springcorestudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SpringCoreStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreStudyApplication.class, args);
	}

}
