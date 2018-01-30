package com.ihg.redirect.app;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ihg.redirect.utils.RedirectUtils;

@Controller
public class Redirects {
	private static final Logger logger = LogManager.getLogger(Redirects.class);

	@Autowired
	URLBuilder urlbuilder;

	@RequestMapping("/redirect")
	public void processRedirect(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		RedirectUtils.logAllRequestParams(req);
		final String redirectURL = this.urlbuilder.buildLandingPage(req);
		RedirectUtils.sendRedirect(redirectURL, resp);
	}
}
