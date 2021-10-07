package com.rushdynamic.finalism.dto;

import lombok.Data;

@Data
public class OriginalUrlResponseOutput {
	
	OriginalUrlOutputDto originalUrlOutput;
	
	ResponseOutput response;

	public OriginalUrlResponseOutput(OriginalUrlOutputDto originalUrlOutput, ResponseOutput response) {
		super();
		this.originalUrlOutput = originalUrlOutput;
		this.response = response;
	}
	
}
