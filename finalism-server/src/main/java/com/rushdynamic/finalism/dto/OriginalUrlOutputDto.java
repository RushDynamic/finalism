package com.rushdynamic.finalism.dto;

import lombok.Data;

@Data
public class OriginalUrlOutputDto {
	
	public boolean success;
	
	public String originalUrl;

	public OriginalUrlOutputDto(boolean success, String originalUrl) {
		super();
		this.success = success;
		this.originalUrl = originalUrl;
	}
	
	public OriginalUrlOutputDto(boolean success) {
		super();
		this.success = success;
	}
}
