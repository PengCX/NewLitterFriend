package com.example.newlitterfriend.model.bean;

/**
 * 用户信息
 *
 * @author xiang_000
 *
 */
public class UserInfo {
	/** 用户名 */
	private String _fName;
	/** 头像图片名称 */
	private String _fIconName;

	public UserInfo(String aName, String aIconName) {
		super();
		_fName = aName;
		_fIconName = aIconName;
	}

	public String get_fName() {
		return _fName;
	}

	public void set_fName(String aName) {
		_fName = aName;
	}

	public String get_fIconName() {
		return _fIconName;
	}

	public void set_fIconName(String aIconName) {
		_fIconName = aIconName;
	}
}
