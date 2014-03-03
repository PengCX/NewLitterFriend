package com.example.newlitterfriend.control.asynctask;

/**
 * 结果状态枚举：描述了网络连接返回的结果状态
 * 
 * @author Administrator
 * 
 */
public enum ResultState {
	SUCCESS("0");
	/** 状态码 */
	private String _fStateCode;

	/**
	 * 获取状态码
	 * 
	 * @return 状态码
	 */
	public String get_fStateCode() {
		return _fStateCode;
	}

	private ResultState(String aStateCode) {
		_fStateCode = aStateCode;
	}
}
