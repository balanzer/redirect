package com.ihg.redirect.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.ihg.redirect.config.ConfigProperties;

@Component
public class RedirectConfig {
	private static final Logger logger = LogManager.getLogger(RedirectConfig.class);

	@Autowired
	ConfigProperties config;
	final String DEFAULT_BRAND_CODE = "6c";

	@Cacheable(cacheNames = "brandURL", key = "{#brandCode,#dpReqd}")
	public String getBrandURL(String brandCode, final boolean dpReqd) {
		logger.debug("getBrandURL - code={},dp={} ", brandCode, dpReqd);
		if (StringUtils.isNotEmpty(brandCode)) {
			brandCode = brandCode.toLowerCase();
		} else {
			brandCode = this.DEFAULT_BRAND_CODE;
		}

		if (dpReqd) {
			if (this.config.getDpbrands().containsKey(brandCode)) {
				return this.config.getDpbrands().get(brandCode);
			} else {
				return this.config.getDpbrands().get(this.DEFAULT_BRAND_CODE);
			}
		} else {

			if (this.config.getBrands().containsKey(brandCode)) {
				return this.config.getBrands().get(brandCode);
			} else {
				return this.config.getBrands().get(this.DEFAULT_BRAND_CODE);
			}
		}

	}

}
