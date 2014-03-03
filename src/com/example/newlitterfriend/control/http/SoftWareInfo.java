package com.example.newlitterfriend.control.http;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;

/**
 * 应用软件信息类
 * 
 * @author Administrator
 * 
 */
public class SoftWareInfo {
	/** 上下文对象 */
	private Context _fContext;
	/** 软件渠道号 */
	public static final String CHANNEL_ID = "14";
	/** Token */
	public static String TOKEN_ID = "";

	public SoftWareInfo(Context aContext) {
		super();
		_fContext = aContext;
	}

	public String getVersionID() {
		/** 软件版本号 */
		String versionName = null;

		try {
			String packageNameString = _fContext.getPackageName();
			versionName = _fContext.getPackageManager().getPackageInfo(
					packageNameString, 0).versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}

		return versionName;
	}
}
