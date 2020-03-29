package com.natnasolutions.ticketing.util;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class RecordNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2414780356227530543L;

	public RecordNotFoundException(String exception) {
		super(exception);
	}

}
