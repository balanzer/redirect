/**
 *
 */
package com.ihg.redirect.app;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ihg.redirect.utils.RedirectUtils;

/**
 * @author varathm
 *
 */
@RestController
public class RedirectREST {
	private static final Logger LOGGER = LogManager.getLogger(Redirects.class);

	@Autowired
	URLBuilder urlbuilder;

	@RequestMapping(method = RequestMethod.GET, value = "/redirect")
	public void processRedirect(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {

		RedirectUtils.logAllRequestParams(req);
		final String redirectURL = this.urlbuilder.buildLandingPage(req);
		LOGGER.info("Redirect URL : {} ", redirectURL);
		RedirectUtils.sendRedirect(redirectURL, resp);

	}

}
