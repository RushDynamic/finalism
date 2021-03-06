package com.rushdynamic.finalism.service;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.rushdynamic.finalism.repository.UrlRepository;

@Service
public class TrackingService {
	
	Logger logger = LoggerFactory.getLogger(TrackingService.class);
	
	@Autowired
	private UrlRepository urlRepository;

	@Async
	public void trackHits(String shortUrl) {
		logger.info("Entered trackHits(): " + shortUrl);
		urlRepository.incrementHits(shortUrl, Timestamp.from(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toInstant()));
		logger.info("Invoked incrementHits()");
	}
}
