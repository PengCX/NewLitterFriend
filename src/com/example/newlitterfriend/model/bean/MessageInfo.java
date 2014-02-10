package com.example.newlitterfriend.model.bean;

/**
 * 消息信息
 *
 * @author xiang_000
 *
 */
public class MessageInfo {
	/** 消息 */
	private String _fMessage;
	/** 接收时间 */
	private String _fRecivedTime;

	public MessageInfo(String aMessage, String aRecivedTime) {
		super();
		_fMessage = aMessage;
		_fRecivedTime = aRecivedTime;
	}

	public String get_fMessage() {
		return _fMessage;
	}

	public void set_fMessage(String aMessage) {
		_fMessage = aMessage;
	}

	public String get_fRecivedTime() {
		return _fRecivedTime;
	}

	public void set_fRecivedTime(String aRecivedTime) {
		_fRecivedTime = aRecivedTime;
	}
}
