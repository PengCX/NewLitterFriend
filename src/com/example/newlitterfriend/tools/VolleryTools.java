package com.example.newlitterfriend.tools;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * 联网工具类，使用Android Asynchronous Http Client框架
 * 
 * @author Administrator
 * 
 */
public class VolleryTools {
	/** 服务器基本地址 */
	private static final String BASE_URL = "http://58.83.193.120";
	/** 服务器post请求地址 */
	public static final String URL_POST = "/gamepro/request";
	/** 服务器图片下载地址 */
	public static final String URL_PICTURE = "/gamepro/fileserver/get/";

	private static AsyncHttpClient client = new AsyncHttpClient();

	public static void get(String url, RequestParams params,
			AsyncHttpResponseHandler responseHandler) {
		client.get(getAbsoluteUrl(url), params, responseHandler);
	}

	public static void post(String url, RequestParams params,
			AsyncHttpResponseHandler responseHandler) {
		client.post(getAbsoluteUrl(url), params, responseHandler);
	}

	private static String getAbsoluteUrl(String relativeUrl) {
		return BASE_URL + relativeUrl;
	}
}
