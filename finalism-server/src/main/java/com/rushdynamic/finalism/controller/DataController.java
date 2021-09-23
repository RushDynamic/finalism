package com.rushdynamic.finalism.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rushdynamic.finalism.dto.ResponseOutput;
import com.rushdynamic.finalism.dto.ShortenUrlInputDto;
import com.rushdynamic.finalism.dto.ShortenUrlOutputDto;
import com.rushdynamic.finalism.dto.ShortenUrlResponseOutput;
import com.rushdynamic.finalism.service.ShortenUrlService;

@RestController
public class DataController {

	@Autowired
	private ShortenUrlService shortenUrlService;
	
	@PostMapping("/shorten")
	public ShortenUrlResponseOutput echo(@RequestBody ShortenUrlInputDto shortenUrlInput) {
		ShortenUrlResponseOutput shortenUrlOutputResponse = new ShortenUrlResponseOutput();
		ShortenUrlOutputDto shortenUrlOutput = shortenUrlService.shortenUrl(shortenUrlInput);
		
		ResponseOutput response = new ResponseOutput();
		response.setStatus("200");
		response.setMessage("Successfully shortened URL");
		shortenUrlOutputResponse.setShortenUrlOutput(shortenUrlOutput);
		shortenUrlOutputResponse.setResponse(response);
		return shortenUrlOutputResponse;
	}
}
