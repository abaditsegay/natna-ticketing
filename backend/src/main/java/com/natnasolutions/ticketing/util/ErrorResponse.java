package com.natnasolutions.ticketing.util;

import java.util.List;

import lombok.Data;

@Data
public class ErrorResponse {

	private String message;
	private List<?> details;

	public ErrorResponse(String message) {
		this.message = message;
	}

	public ErrorResponse(String message, List<?> details) {
		super();
		this.message = message;
		this.details = details;
	}

}
