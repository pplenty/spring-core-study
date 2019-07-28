package com.jason.springcorestudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@EnableAsync
@SpringBootApplication
public class SpringCoreStudyApplication {
	public static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss z";

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreStudyApplication.class, args);
		/*System.out.println(",\n" +
				"  \"aggs\": {\n" +
				"    \"keywordCount\": {\n" +
				"      \"terms\": {\n" +
				"        \"field\": \"data.keyword.keyword\",\n" +
				"        \"size\" : 1000\n" +
				"      }\n" +
				"    }\n" +
				"  }");


		LocalDateTime ldt = LocalDateTime.now();

		System.out.println(ldt);

		ZonedDateTime zdt = ZonedDateTime.now();

		System.out.println(zdt.getZone());



		System.out.println(zdt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));*/
	}

}
