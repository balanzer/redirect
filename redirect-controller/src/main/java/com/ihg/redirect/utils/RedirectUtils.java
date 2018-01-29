package com.ihg.redirect.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RedirectUtils {

	static String DEFAULT_HOME_PAGE = "https://www.ihg.com";

	private static final Logger logger = LogManager.getLogger(RedirectUtils.class);

	public static void sendRedirect(final String url, final HttpServletResponse resp) throws IOException {
		if (StringUtils.isNotEmpty(url)) {
			resp.sendRedirect(url);
		} else {
			// Redirect to IHG.com home page
			resp.sendRedirect(DEFAULT_HOME_PAGE);
		}
	}
}
