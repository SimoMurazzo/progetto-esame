package com.esame.exception;

public class FilterNotFoundException extends ClassNotFoundException {

	private static final long serialVersionUID = 1L;

	public FilterNotFoundException() {
		super();
	}
	
	public FilterNotFoundException(String message) {
		super(message);
	}
}
