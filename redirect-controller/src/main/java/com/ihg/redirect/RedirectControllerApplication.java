package com.ihg.redirect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class RedirectControllerApplication {
	private static final Logger logger = LogManager.getLogger(RedirectControllerApplication.class);

	public static void main(final String[] args) {
		SpringApplication.run(RedirectControllerApplication.class, args);
		logger.info("**** Redirect Controller Application - Started ******");
	}
}
