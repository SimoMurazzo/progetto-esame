package com.esame.exception;

/**
 * Rappresenta un'eccezione personalizzata di tipo ClassNotFoundException
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/ClassNotFoundException.html">https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/ClassNotFoundException.html</a>
 * @author Sergio Galletto
 * @author Simone Murazzo
 */
public class FilterNotFoundException extends ClassNotFoundException {

	private static final long serialVersionUID = 1L;

	public FilterNotFoundException() {
		super();
	}
	
	public FilterNotFoundException(String message) {
		super(message);
	}
}
