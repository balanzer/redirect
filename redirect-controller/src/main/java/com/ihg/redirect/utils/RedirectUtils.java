package com.ihg.redirect.utils;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RedirectUtils {

	static String DEFAULT_HOME_PAGE = "https://www.ihg.com";

	private static final Logger logger = LogManager.getLogger(RedirectUtils.class);

	public static void logAllRequestParams(final HttpServletRequest req) {
		try {
			final Map<String, String[]> requestParameterMap = req.getParameterMap();

			for (final Entry<String, String[]> entry : requestParameterMap.entrySet()) {
				final String key = entry.getKey();
				final String[] value = entry.getValue();
				logger.debug("Key : {}, Value: {}", key, value);

			}
		} catch (final Exception exp) {
			// Ignore any errors
		}
	}

	public static void sendRedirect(final String url, final HttpServletResponse resp) throws IOException {
		if (StringUtils.isNotEmpty(url)) {
			logger.debug("Redirect to {}", url);
			// resp.sendRedirect(url);
		} else {
			logger.debug("Redirect to home page");
			// Redirect to IHG.com home page
			// resp.sendRedirect(DEFAULT_HOME_PAGE);
		}
	}
}
