package com.jason.springcorestudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@EnableAsync
@SpringBootApplication
public class SpringCoreStudyApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCoreStudyApplication.class, args);
	}

}
