package com.example.newlitterfriend.control.activity;

import android.content.Intent;
import roboguice.activity.RoboFragmentActivity;

/**
 * 基本的Activity，提供了一些基本的方法
 * 
 * @author Administrator
 * 
 */
public class BaseRoboFragmentActivity extends RoboFragmentActivity {

	/**
	 * 通过Class跳转界面
	 * 
	 * @param cls
	 *            跳转页面的类
	 */
	protected void startActivity(Class<?> cls) {
		Intent intent = new Intent(this, cls);
		startActivity(intent);
	}

}
