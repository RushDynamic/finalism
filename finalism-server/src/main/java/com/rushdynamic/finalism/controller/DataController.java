package com.rushdynamic.finalism.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rushdynamic.finalism.dto.ShortenUrlInputDto;
import com.rushdynamic.finalism.dto.ShortenUrlResponseOutput;

@RestController
public class DataController {

	@PostMapping("/shorten")
	public ShortenUrlResponseOutput echo(@RequestBody ShortenUrlInputDto shortenUrlInput) {
		ShortenUrlResponseOutput shortenUrlOutputResponse = new ShortenUrlResponseOutput();
		// TODO: call service to shorten url here
		return shortenUrlOutputResponse;
	}
}
