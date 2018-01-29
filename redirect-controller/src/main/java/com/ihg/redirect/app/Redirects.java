package com.ihg.redirect.app;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ihg.redirect.utils.RedirectConfig;
import com.ihg.redirect.utils.RedirectUtils;

@Controller
public class Redirects {
	private static final Logger logger = LogManager.getLogger(Redirects.class);

	@Autowired
	RedirectConfig config;

	private String buildLandingPageURL(final HttpServletRequest req) {

		final StringBuilder redirectURL = new StringBuilder("");
		redirectURL.append(this.handleHostName());
		logger.debug("buildRedirect - {} ", redirectURL.toString());
		return redirectURL.toString();
	}

	private String handleHostBrand(final String brandCode, final boolean dpReqd) {
		return this.config.getBrandURL(brandCode, dpReqd);
	}

	private String handleHostName() {
		final StringBuilder hostURL = new StringBuilder("");
		// Add protocol
		hostURL.append(this.handleProtocol());
		// add brandHost based on DP param
		hostURL.append(this.handleHostBrand("", false));

		return hostURL.toString();
	}

	private String handleProtocol() {
		return "https://";
	}

	@RequestMapping("/redirect")
	public void processRedirect(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		RedirectUtils.logAllRequestParams(req);
		final String redirectURL = this.buildLandingPageURL(req);
		RedirectUtils.sendRedirect(redirectURL, resp);
	}
}
