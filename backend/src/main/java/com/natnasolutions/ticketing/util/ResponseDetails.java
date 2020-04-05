package com.natnasolutions.ticketing.util;

import java.util.List;

import lombok.Data;

@Data
public class ResponseDetails {

	private String responseCode;
	private String responseMessage;
	private List<?> responseDetails;

	public ResponseDetails(String responseCode, String responseMessage) {
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

	public ResponseDetails(String responseCode, String responseMessage, List<?> responseDetails) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
		this.responseDetails = responseDetails;
	}
}
