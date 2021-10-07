package com.rushdynamic.finalism.dto;

import lombok.Data;

@Data
public class ResponseOutput {
	
	private String status;
	
	private String message;

	public ResponseOutput(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	} 
}
