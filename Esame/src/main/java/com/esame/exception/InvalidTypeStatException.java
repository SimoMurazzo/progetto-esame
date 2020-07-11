package com.esame.exception;

public class InvalidTypeStatException extends ClassNotFoundException{
	
	private static final long serialVersionUID = 1L;
	
	public InvalidTypeStatException() {
		super();
	}
	
	public InvalidTypeStatException(String message) {
		super(message);
	}
}
