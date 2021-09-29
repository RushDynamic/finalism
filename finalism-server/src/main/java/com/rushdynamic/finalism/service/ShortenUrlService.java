package com.rushdynamic.finalism.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.rushdynamic.finalism.dto.ShortenUrlInputDto;
import com.rushdynamic.finalism.dto.ShortenUrlOutputDto;
import com.rushdynamic.finalism.entity.UrlEntity;
import com.rushdynamic.finalism.repository.UrlRepository;
import com.rushdynamic.finalism.util.FinalismAppUtil;

public class ShortenUrlService {
	
	Logger logger = LoggerFactory.getLogger(ShortenUrlService.class);
	
	@Autowired
	private UrlRepository urlRepository;
	
	public ShortenUrlOutputDto shortenUrl(ShortenUrlInputDto shortenUrlInput) {
		ShortenUrlOutputDto shortenUrlOutput = new ShortenUrlOutputDto();
		String shortUrl = generateUrlToken(shortenUrlInput.getOriginalUrl());
		shortenUrlOutput.setShortenedUrl(shortUrl);
		
		// write to DB
		try {
			UrlEntity urlEntity = new UrlEntity();
			urlEntity.setShortUrl(shortUrl);
			urlEntity.setOriginalUrl(shortenUrlInput.getOriginalUrl());
			urlRepository.save(urlEntity);
		}
		catch(DataIntegrityViolationException ex) {
			logger.debug("URL already exists in DB, returning existing shortened URL");
		}
		return shortenUrlOutput;
	}
	
	private String generateUrlToken(String originalUrl) {
		String cleanUrl = FinalismAppUtil.cleanUrl(originalUrl);
		return tokenize(cleanUrl);
	}
	
	private String tokenize(String inputStr) {
		return inputStr.substring(0,3) + inputStr.substring(inputStr.length()/2, inputStr.length()/2+1) + inputStr.substring(inputStr.length()-3, inputStr.length());
	}
}
