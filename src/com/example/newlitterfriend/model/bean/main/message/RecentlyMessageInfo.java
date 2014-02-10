package com.example.newlitterfriend.model.bean.main.message;

import com.example.newlitterfriend.model.bean.MessageInfo;
import com.example.newlitterfriend.model.bean.UserInfo;

/**
 * 最近消息
 *
 * @author xiang_000
 *
 */
public class RecentlyMessageInfo {
	/** 发送消息的用户 */
	private UserInfo _fUserInfo;
	/** 最近消息信息 */
	private MessageInfo _fMessageInfo;

	public RecentlyMessageInfo(UserInfo aUserInfo, MessageInfo aMessageInfo) {
		super();
		_fUserInfo = aUserInfo;
		_fMessageInfo = aMessageInfo;
	}

	public UserInfo get_fUserInfo() {
		return _fUserInfo;
	}

	public void set_fUserInfo(UserInfo aUserInfo) {
		_fUserInfo = aUserInfo;
	}

	public MessageInfo get_fMessageInfo() {
		return _fMessageInfo;
	}

	public void set_fMessageInfo(MessageInfo aMessageInfo) {
		_fMessageInfo = aMessageInfo;
	}
}
