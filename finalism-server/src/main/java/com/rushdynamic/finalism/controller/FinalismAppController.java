package com.rushdynamic.finalism.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rushdynamic.finalism.dto.OriginalUrlResponseOutput;
import com.rushdynamic.finalism.dto.ResponseOutput;
import com.rushdynamic.finalism.dto.ShortenUrlInputDto;
import com.rushdynamic.finalism.dto.ShortenUrlOutputDto;
import com.rushdynamic.finalism.dto.ShortenUrlResponseOutput;
import com.rushdynamic.finalism.service.ShortenUrlService;

@CrossOrigin
@RestController
public class FinalismAppController {

	@Autowired
	private ShortenUrlService shortenUrlService;
	
	@PostMapping("/shorten")
	public ShortenUrlResponseOutput shorten(@RequestBody ShortenUrlInputDto shortenUrlInput) {
		ShortenUrlResponseOutput shortenUrlOutputResponse = new ShortenUrlResponseOutput();
		ShortenUrlOutputDto shortenUrlOutput = shortenUrlService.shortenUrl(shortenUrlInput);
		
		ResponseOutput response = new ResponseOutput("200", "Successfully shortened URL");
		shortenUrlOutputResponse.setShortenUrlOutput(shortenUrlOutput);
		shortenUrlOutputResponse.setResponse(response);
		return shortenUrlOutputResponse;
	}
	
	@GetMapping("/fetch/{shortUrl}")
	public OriginalUrlResponseOutput fetchOriginalUrl(@PathVariable("shortUrl") String shortUrl) throws URISyntaxException {
		ResponseOutput response = new ResponseOutput("200", "Successfully fetched original URL");
		return new OriginalUrlResponseOutput(shortenUrlService.fetchOriginalUrl(shortUrl), response);
	}
}
