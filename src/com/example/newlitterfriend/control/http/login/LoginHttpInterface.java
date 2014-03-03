package com.example.newlitterfriend.control.http.login;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.example.newlitterfriend.control.http.BaseHttpInterface;

/**
 * 登陆接口
 * 
 * @author Administrator
 * 
 */
public class LoginHttpInterface extends BaseHttpInterface {
	/** 方法标识 */
	private static final String METHOD = "101";
	/** 用户名 */
	private String _fUserName;
	/** 密码 */
	private String _fPassWord;

	public LoginHttpInterface(Context aContext, String aUserName,
			String aPassWord) {
		super(aContext);
		_fUserName = aUserName;
		_fPassWord = aPassWord;
	}

	@Override
	public void setParticularParamerters(JSONObject aParamtersJsonObject) {
		try {
			aParamtersJsonObject.put("username", _fUserName);
			aParamtersJsonObject.put("password", _fPassWord);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setMethodDefaultParamsters(JSONObject aSubParamtersJsonObject) {
		try {
			aSubParamtersJsonObject.put("method", METHOD);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
