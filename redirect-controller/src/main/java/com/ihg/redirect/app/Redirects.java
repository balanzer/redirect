package com.ihg.redirect.app;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ihg.redirect.utils.RedirectUtils;

@Controller
public class Redirects {
	private static final Logger logger = LogManager.getLogger(Redirects.class);

	@RequestMapping("/redirect")
	public void handleRedirects(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		final Map<String, String[]> requestParameterMap = req.getParameterMap();
		for (final String key : requestParameterMap.keySet()) {
			logger.debug("Key : " + key + ", Value: " + requestParameterMap.get(key)[0]);
		}
		RedirectUtils.sendRedirect("", resp);
	}
}
