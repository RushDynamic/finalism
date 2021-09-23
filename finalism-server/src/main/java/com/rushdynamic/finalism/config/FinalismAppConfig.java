package com.rushdynamic.finalism.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rushdynamic.finalism.service.ShortenUrlService;

@Configuration
public class FinalismAppConfig {
	
	@Bean
	public ShortenUrlService shortenUrlService() {
		return new ShortenUrlService();
	}
}
