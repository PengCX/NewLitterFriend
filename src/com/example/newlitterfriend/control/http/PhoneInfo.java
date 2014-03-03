package com.example.newlitterfriend.control.http;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

/**
 * 手机信息类
 * 
 * @author Administrator
 * 
 */
public class PhoneInfo {
	/** WIFI管理对象 */
	private WifiManager _fWifiManager;
	/** 手机管理对象 */
	private TelephonyManager _fTelephonyManager;
	/** GPS*管理 */
	private LocationManager _fLocationManager;

	public PhoneInfo(Context aContext) {
		super();
		_fWifiManager = (WifiManager) aContext
				.getSystemService(Context.WIFI_SERVICE);
		_fTelephonyManager = (TelephonyManager) aContext
				.getSystemService(Context.TELEPHONY_SERVICE);
		_fLocationManager = (LocationManager) aContext
				.getSystemService(Context.LOCATION_SERVICE);
	}

	/**
	 * 获取手机联网的mac地址
	 * 
	 * @return mac地址
	 */
	public String getMac() {
		// 如果是模拟器，Mac为null
		WifiInfo wifiInfo = _fWifiManager.getConnectionInfo();
		return wifiInfo.getMacAddress();
	}

	/**
	 * 获取手机身份码
	 * 
	 * @return 手机身份码
	 */
	public Object getImei() {
		return _fTelephonyManager.getDeviceId();
	}

	/**
	 * 获取经度
	 * 
	 * @return 经度值
	 */
	public double getLongitude() {
		Location location = _fLocationManager
				.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		return location.getLongitude();
	}

	/**
	 * 获取纬度
	 * 
	 * @return 纬度值
	 */
	public double getLatitude() {
		Location location = _fLocationManager
				.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		return location.getLatitude();
	}
}
