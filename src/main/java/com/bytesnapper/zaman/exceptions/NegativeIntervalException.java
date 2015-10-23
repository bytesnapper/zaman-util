package com.bytesnapper.zaman.exceptions;

public class NegativeIntervalException extends RuntimeException {

	public NegativeIntervalException() {
		super();
	}

	public NegativeIntervalException(String message) {
		super(message);
	}

	public String getMessage() {
		return super.getMessage();
	}

}
