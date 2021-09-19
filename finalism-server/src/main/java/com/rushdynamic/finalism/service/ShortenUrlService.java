package com.rushdynamic.finalism.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.rushdynamic.finalism.dto.ShortenUrlOutputDto;
import com.rushdynamic.finalism.repository.UrlRepository;

public class ShortenUrlService {
	
	@Autowired
	UrlRepository urlRepository;
	
	public ShortenUrlOutputDto shortenUrl() {
		ShortenUrlOutputDto shortenUrlOutput = new ShortenUrlOutputDto();
		// TODO: Implement URL shortening logic here
		return shortenUrlOutput;
	}
}
