package com.rushdynamic.finalism.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class OriginalUrlResponseOutput implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	OriginalUrlOutputDto originalUrlOutput;
	
	ResponseOutput response;

	public OriginalUrlResponseOutput(OriginalUrlOutputDto originalUrlOutput, ResponseOutput response) {
		super();
		this.originalUrlOutput = originalUrlOutput;
		this.response = response;
	}
	
}
