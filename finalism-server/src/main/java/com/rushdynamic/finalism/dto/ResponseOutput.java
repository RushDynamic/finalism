package com.rushdynamic.finalism.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResponseOutput implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String status;
	
	private String message;

	public ResponseOutput(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	} 
}
