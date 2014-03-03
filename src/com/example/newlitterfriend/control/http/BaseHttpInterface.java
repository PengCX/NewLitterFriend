package com.example.newlitterfriend.control.http;

import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.newlitterfriend.tools.HttpURLConnectionTools;
import com.example.newlitterfriend.tools.LogTools;
import com.example.newlitterfriend.tools.LogTools.LogType;

import android.content.Context;

/**
 * 小伙伴网络接口基础
 * 
 * @author Administrator
 * 
 */
public abstract class BaseHttpInterface {
	/** 上下文对象 */
	private Context _fContext;
	/** 联网参数Json对象 */
	private JSONObject _fParamtersJsonObject;

	/**
	 * 设置接口特有参数
	 * 
	 * @param aSubParamtersJsonObject
	 *            将要保存特有参数的Json对象
	 * @return 保存了特有参数的Json对象
	 */
	public abstract void setParticularParamerters(
			JSONObject aSubParamtersJsonObject);

	/**
	 * 设置共同"method"参数
	 * 
	 * @param aParamtersJsonObject
	 *            保存共同参数的Json对象
	 */
	public abstract void setMethodDefaultParamsters(
			JSONObject aParamtersJsonObject);

	public BaseHttpInterface(Context aContext) {
		super();
		_fContext = aContext;
	}

	/**
	 * 获取网络数据
	 * 
	 * @return
	 */
	public String getJsonObjectStringFromIntenet() {
		setRequestParametersJsonObject();

		return HttpURLConnectionTools
				.getIntenetDateByPost(_fParamtersJsonObject.toString());
	}

	/**
	 * 设置请求参数
	 * 
	 * @throws HttpInterfaceParamertersException
	 */
	private void setRequestParametersJsonObject() {
		// 设置默认的参数
		setDefaultParamstersJsonObject();

		try {
			// 特殊参数子Json对象
			JSONObject particularJsonObject = new JSONObject();
			setParticularParamerters(particularJsonObject);
			_fParamtersJsonObject.put("params", particularJsonObject);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		LogTools.showLog(LogTools.TAG,
				"请求的联网参数字符串：" + _fParamtersJsonObject.toString(), LogType.INFO);
	}

	/**
	 * 
	 * @return 参数JsonObject
	 */
	private void setDefaultParamstersJsonObject() {
		_fParamtersJsonObject = new JSONObject();

		SoftWareInfo softWareInfo = new SoftWareInfo(_fContext);
		PhoneInfo phoneInfo = new PhoneInfo(_fContext);

		try {
			setMethodDefaultParamsters(_fParamtersJsonObject);
			// 设置渠道号
			_fParamtersJsonObject.put("channel", SoftWareInfo.CHANNEL_ID);
			_fParamtersJsonObject.put("token", SoftWareInfo.TOKEN_ID);
			// 设置版本号
			_fParamtersJsonObject.put("sn", generateUUID());
			// 是否加密
			_fParamtersJsonObject.put("encrypt", "false");
			// 设置是否压缩
			_fParamtersJsonObject.put("compression", "false");
			// 设置版本号
			_fParamtersJsonObject.put("version", softWareInfo.getVersionID());
			// 设置网卡地址
			_fParamtersJsonObject.put("mac", phoneInfo.getMac());
			// 设置imei
			_fParamtersJsonObject.put("imei", phoneInfo.getImei());
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成UUID字符串
	 * 
	 * @return UUID字符串
	 */
	private String generateUUID() {
		UUID uuid = UUID.randomUUID();
		String uuidstr = uuid.toString();
		return uuidstr;
	}
}
