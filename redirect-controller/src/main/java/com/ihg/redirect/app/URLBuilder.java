package com.ihg.redirect.app;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ihg.redirect.utils.ParameterNames;
import com.ihg.redirect.utils.RedirectConfig;

@Component
public class URLBuilder {

	private static final Logger logger = LogManager.getLogger(URLBuilder.class);

	@Autowired
	RedirectConfig config;

	public String buildLandingPage(final HttpServletRequest req) {

		final StringBuilder redirectURL = new StringBuilder("");
		if ((null != req) && !req.getParameterMap().isEmpty()) {
			redirectURL.append(this.buildLandingPageURL(req));
			logger.debug("buildLandingPageURL - {} ", redirectURL.toString());
		}
		return redirectURL.toString();
	}

	private String buildLandingPageURL(final HttpServletRequest req) {
		final StringBuilder landingURL = new StringBuilder("");

		final String brandCode = this.getRequestParameter(req, ParameterNames.BRAND_CODE);
		final String dp = this.getRequestParameter(req, ParameterNames.DP);

		landingURL.append(this.handleHostName(brandCode, dp));
		landingURL.append(this.handleBrand());
		landingURL.append(this.handleLanguage());
		landingURL.append(this.handleLandingSection());

		return landingURL.toString();
	}

	String getRequestParameter(final HttpServletRequest req, final String paramName) {
		if ((null != req) && StringUtils.isNotEmpty(paramName)) {
			return req.getParameter(paramName);
		}
		return null;
	}

	private String handleBrand() {
		// TODO Auto-generated method stub
		return null;
	}

	String handleHostBrand(final String brandCode, final boolean dpReqd) {
		return this.config.getBrandURL(brandCode, dpReqd);
	}

	String handleHostName(final String brandCode, final String dpReqd) {
		final StringBuilder hostURL = new StringBuilder("");
		// Add protocol
		hostURL.append(this.handleProtocol());
		// add brandHost based on DP param
		boolean dpReqdFlg = false;
		if (StringUtils.isNotEmpty(dpReqd) && dpReqd.toLowerCase().equals("true")) {
			dpReqdFlg = true;
		}

		hostURL.append(this.handleHostBrand(brandCode, dpReqdFlg));

		return hostURL.toString();
	}

	private String handleLandingSection() {
		// TODO Auto-generated method stub
		return null;
	}

	private String handleLanguage() {
		// TODO Auto-generated method stub
		return null;
	}

	String handleProtocol() {
		return "https://";
	}

}
