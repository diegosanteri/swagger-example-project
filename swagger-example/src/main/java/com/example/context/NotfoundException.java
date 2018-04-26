package com.example.context;

public class NotfoundException extends RuntimeException{

	private static final long serialVersionUID = -6642359802463586691L;
	private final String message;
	
	public NotfoundException(String message) {
		this.message = message;
	}
	
	public NotfoundException(String message, RuntimeException e) {
		super(e);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
