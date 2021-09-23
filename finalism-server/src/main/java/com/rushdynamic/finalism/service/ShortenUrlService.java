package com.rushdynamic.finalism.service;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;

import com.rushdynamic.finalism.dto.ShortenUrlInputDto;
import com.rushdynamic.finalism.dto.ShortenUrlOutputDto;
import com.rushdynamic.finalism.entity.UrlEntity;
import com.rushdynamic.finalism.repository.UrlRepository;

public class ShortenUrlService {
	
	@Autowired
	private UrlRepository urlRepository;
	
	public ShortenUrlOutputDto shortenUrl(ShortenUrlInputDto shortenUrlInput) {
		ShortenUrlOutputDto shortenUrlOutput = new ShortenUrlOutputDto();
		String shortUrl = generateUrlToken(shortenUrlInput.getOriginalUrl());
		shortenUrlOutput.setShortenedUrl(shortUrl);
		
		// write to DB
		UrlEntity urlEntity = new UrlEntity();
		urlEntity.setShortUrl(shortUrl);
		urlEntity.setOriginalUrl(shortenUrlInput.getOriginalUrl());
		urlRepository.save(urlEntity);
		
		return shortenUrlOutput;
	}
	
	private String generateUrlToken(String originalUrl) {
		String cleanUrl = cleanUrl(originalUrl);
		return tokenize(cleanUrl);
	}
	
	private String rightPadString(String inputStr, Integer paddingLen) {
		return (inputStr.length() < paddingLen ? rightPadString(inputStr + "0", paddingLen) : inputStr);
	}
	
	private String encodeBase64(String inputStr) {
		return Base64.getEncoder().encodeToString(inputStr.getBytes());
	}
	
	private String cleanUrl(String originalUrl) {
		// TODO: Remove http/https, www, and // before encoding
		String encodedUrl = encodeBase64(originalUrl);
		String cleanUrl = encodedUrl.replaceAll("[^a-zA-Z0-9]", "");
		return rightPadString(cleanUrl, 7);
	}
	
	private String tokenize(String inputStr) {
		return inputStr.substring(0,3) + inputStr.substring(inputStr.length()/2, inputStr.length()/2+1) + inputStr.substring(inputStr.length()-3, inputStr.length());
	}
}
