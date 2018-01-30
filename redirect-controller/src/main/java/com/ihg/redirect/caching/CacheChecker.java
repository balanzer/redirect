package com.ihg.redirect.caching;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ihg.redirect.utils.RedirectConfig;

@Component
public class CacheChecker {
	private static final Logger logger = LogManager.getLogger(CacheChecker.class);
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Autowired
	private CacheManager cacheManager;

	@Autowired
	RedirectConfig configs;

	@Scheduled(fixedDelay = 30000)
	public void checkCacheWithFixedDelay() {
		logger.info("CacheChecker :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));

		try {

			logger.info("Using cache manager: " + this.cacheManager.getClass().getName());
			logger.info("Calling getBrandURL");
			this.configs.getBrandURL("ex", false);

		} catch (final Exception ex) {
			logger.error("CacheChecker - Ran into an error {}", ex);
			throw new IllegalStateException(ex);
		}
	}

}
