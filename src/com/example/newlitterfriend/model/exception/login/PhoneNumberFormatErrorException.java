package com.example.newlitterfriend.model.exception.login;

/**
 * 手机号码格式错误异常
 * 
 * @author Administrator
 * 
 */
public class PhoneNumberFormatErrorException extends Exception {

	private static final long serialVersionUID = -2768888408183329195L;

	public PhoneNumberFormatErrorException(String message) {
		super(message);
	}
}
