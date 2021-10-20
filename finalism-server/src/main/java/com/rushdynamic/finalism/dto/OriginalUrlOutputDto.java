package com.rushdynamic.finalism.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class OriginalUrlOutputDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
