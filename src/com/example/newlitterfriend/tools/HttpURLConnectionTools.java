package com.example.newlitterfriend.tools;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 使用HttpURLConnection联网工具类
 * 
 * @author Administrator
 * 
 */
public class HttpURLConnectionTools {
	/** 服务器URL地址 */
	private static final String SERVER_URL = "http://58.83.193.120";
	/** Post请求地址 */
	private static final String POST_URL = SERVER_URL + "/gamepro/request";
	/** 图片请求地址 */
	private static final String PICTURE_URL = SERVER_URL
			+ "/gamepro/fileserver/get/";

	/** 连接超时 */
	private static final int CONNECTION_TIME_OUT = 5 * 1000;
	/** 读取超时 */
	private static final int READ_TIME_OUT = 3 * 1000;

	/** 连接成功标识 */
	private static final int CONNECTION_SUCCESS_TAG = 200;

	/**
	 * 通过GET的方式获取网络数据
	 * 
	 * @return 返回结果字符串
	 */
	public static String getIntenetDateByGET() {
		URL url;
		HttpURLConnection httpURLConnection = null;
		BufferedReader reader = null;
		String line;
		StringBuffer resultStringBuffer = new StringBuffer();

		try {
			// 1.创建URL对象
			url = new URL("http://www.baidu.com");
			// 2.通过url对象获取HttpURLConnection对象
			httpURLConnection = (HttpURLConnection) url.openConnection();

			// 3.建立网络连接
			httpURLConnection.connect();

			// 4.获取输入流，从流中读取返回结果
			if (httpURLConnection.getResponseCode() == CONNECTION_SUCCESS_TAG) {
				reader = new BufferedReader(new InputStreamReader(
						httpURLConnection.getInputStream()));
				while ((line = reader.readLine()) != null) {
					resultStringBuffer.append(line);
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 5.关闭相关的流和连接
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			httpURLConnection.disconnect();
		}

		return resultStringBuffer.toString();
	}

	/**
	 * 通过POST的方式获取网络数据
	 * 
	 * @param aParamsString
	 *            参数字符串（本项目要求是Json格式）
	 * @return 请求结果字符串
	 */
	public static String getIntenetDateByPost(String aParamsString) {
		// 声明要创建的对象
		URL url;
		HttpURLConnection httpURLConnection = null;
		DataOutputStream outputStream;
		String line;
		BufferedReader reader = null;
		StringBuffer resultStringBuffer = new StringBuffer();

		try {
			// 1.创建URL对象
			url = new URL(POST_URL);
			// 2.通过url对象获取HttpURLConnection对象
			httpURLConnection = (HttpURLConnection) url.openConnection();

			// 3.设置连接的属性
			// 连接超时
			httpURLConnection.setConnectTimeout(CONNECTION_TIME_OUT);
			// 读取超时
			httpURLConnection.setReadTimeout(READ_TIME_OUT);
			// 请求命令
			httpURLConnection.setRequestMethod("POST");
			// 允许输入，是否向connection输出，由于要输出参数，则为true
			httpURLConnection.setDoInput(true);
			// 允许输出
			httpURLConnection.setDoOutput(true);
			// 是否使用缓存,Post请求不能使用缓存
			httpURLConnection.setUseCaches(false);
			// 是否重连
			httpURLConnection.setInstanceFollowRedirects(false);
			// 设置头字段属性
			httpURLConnection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");

			// 4.简历网络连接
			httpURLConnection.connect();

			// 5.获取输出流，并输出参数
			outputStream = new DataOutputStream(
					httpURLConnection.getOutputStream());
			String content = "body="
					+ URLEncoder.encode(aParamsString.toString(), "UTF-8");
			outputStream.writeBytes(content);
			outputStream.flush();

			// 6.获取输入流，从流中读取返回结果
			if (httpURLConnection.getResponseCode() == CONNECTION_SUCCESS_TAG) {
				reader = new BufferedReader(new InputStreamReader(
						httpURLConnection.getInputStream()));
				while ((line = reader.readLine()) != null) {
					resultStringBuffer.append(line);
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 7.关闭相关的流和连接
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			httpURLConnection.disconnect();
		}

		return resultStringBuffer.toString();
	}
}
