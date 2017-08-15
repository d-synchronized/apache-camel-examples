package com.threaddynamics.exception;

public class CamelCustomException extends Exception {

	private static final long serialVersionUID = -5873590490047258201L;

	public CamelCustomException() {
		super();
	}

	public CamelCustomException(String message) {
		super(message);
	}

	public CamelCustomException(String message, Throwable cause) {
		super(message, cause);
	}

	public CamelCustomException(Throwable cause) {
		super(cause);
	}

}
