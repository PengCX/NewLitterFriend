package com.example.newlitterfriend.model.bean.login;

import com.example.newlitterfriend.model.exception.login.PasswordFormatErrorException;
import com.example.newlitterfriend.model.exception.login.PhoneNumberFormatErrorException;

/**
 * 用户信息
 * 
 * @author Administrator
 * 
 */
public class UserInfo {
	/** 登陆手机号 */
	private String _fPhoneNumber;
	/** 登陆密码 */
	private String _fPassWord;

	{
		_fPhoneNumber = "";
		_fPassWord = "";
	}

	public void set_fPhoneNumber(String aPhoneNumber) {
		_fPhoneNumber = aPhoneNumber;
	}

	public void set_fPassWord(String aPassWord) {
		_fPassWord = aPassWord;
	}

	public String getPhoneNumber() throws PhoneNumberFormatErrorException {
		if (_fPhoneNumber.equals("")) {
			throw new PhoneNumberFormatErrorException("手机号码不能为空");
		} else {
			return _fPhoneNumber;
		}
	}

	public String getPassWord() throws PasswordFormatErrorException {
		if (_fPassWord.equals("")) {
			throw new PasswordFormatErrorException("密码不能为空");
		} else {
			return _fPassWord;
		}

	}
}
