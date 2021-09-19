package com.rushdynamic.finalism.dto;

import lombok.Data;

@Data
public class ShortenUrlInputDto {
	
	private String originalUrl;
	
	private String timestamp;

	public ShortenUrlInputDto(String originalUrl, String timestamp) {
		super();
		this.originalUrl = originalUrl;
		this.timestamp = timestamp;
	}
	
}
