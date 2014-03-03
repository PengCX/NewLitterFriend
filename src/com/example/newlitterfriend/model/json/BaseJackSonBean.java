package com.example.newlitterfriend.model.json;

import com.example.newlitterfriend.control.asynctask.ResultState;

/**
 * JackSon解析基类
 * 
 * @author Administrator
 * 
 */
public abstract class BaseJackSonBean {
	private String errorcode;
	private String sn;

	public String getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	/**
	 * 判断返回结果状态
	 * 
	 * @return 返回结果状态枚举
	 */
	public ResultState judgeResultState() {
		ResultState resultState = null;

		if (errorcode.equals(ResultState.SUCCESS.get_fStateCode())) {
			resultState = ResultState.SUCCESS;
		}
		return resultState;
	}

}
