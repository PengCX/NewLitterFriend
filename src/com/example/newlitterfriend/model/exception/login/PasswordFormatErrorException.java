package com.example.newlitterfriend.model.exception.login;

public class PasswordFormatErrorException extends Exception {
	private static final long serialVersionUID = 5005781769726195713L;

	public PasswordFormatErrorException(String message) {
		super(message);
	}
}
