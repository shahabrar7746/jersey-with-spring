package com.poc.api_impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ApiImplApplication extends SpringBootServletInitializer {
//	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public ApiImplApplication() {
	}

//	@PostConstruct
//	public void init() {
//		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//		LOGGER.info("Spring boot application running in UTC timezone :" + String.valueOf(ZonedDateTime.now()));
//	}

	/*protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(new Class[]{ApiImplApplication.class});
	}*/

	public static void main(String[] args) {
		SpringApplication.run(ApiImplApplication.class, args);
	}
}
