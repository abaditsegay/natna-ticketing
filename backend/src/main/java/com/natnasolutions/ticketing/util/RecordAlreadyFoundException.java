package com.natnasolutions.ticketing.util;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class RecordAlreadyFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6968254145523981128L;

	public RecordAlreadyFoundException(String exception) {
		super(exception);
	}

}
