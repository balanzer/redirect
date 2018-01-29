package com.ihg.redirect.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:configprops.properties")
@ConfigurationProperties(prefix = "rd")
public class ConfigProperties {

	private Map<String, String> brands;

	private Map<String, String> dpbrands;

	public Map<String, String> getBrands() {
		return this.brands;
	}

	public Map<String, String> getDpbrands() {
		return this.dpbrands;
	}

	public void setBrands(final Map<String, String> brands) {
		this.brands = brands;
	}

	public void setDpbrands(final Map<String, String> dpbrands) {
		this.dpbrands = dpbrands;
	}

}
