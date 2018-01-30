package com.ihg.redirect.app;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ihg.redirect.utils.RedirectConfig;

@Component
public class URLBuilder {

	private static final Logger logger = LogManager.getLogger(URLBuilder.class);

	@Autowired
	RedirectConfig config;

	public String buildLandingPageURL(final HttpServletRequest req) {

		final StringBuilder redirectURL = new StringBuilder("");
		redirectURL.append(this.handleHostName());
		logger.debug("buildRedirect - {} ", redirectURL.toString());
		return redirectURL.toString();
	}

	String handleHostBrand(final String brandCode, final boolean dpReqd) {
		return this.config.getBrandURL(brandCode, dpReqd);
	}

	String handleHostName() {
		final StringBuilder hostURL = new StringBuilder("");
		// Add protocol
		hostURL.append(this.handleProtocol());
		// add brandHost based on DP param
		hostURL.append(this.handleHostBrand("", false));

		return hostURL.toString();
	}

	String handleProtocol() {
		return "https://";
	}

}
