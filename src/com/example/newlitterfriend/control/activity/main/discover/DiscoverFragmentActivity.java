package com.example.newlitterfriend.control.activity.main.discover;

import roboguice.activity.RoboFragmentActivity;

import com.example.newlitterfriend.R;

import android.os.Bundle;
/**
 * 发现页面
 * @author Dell
 *
 */
public class DiscoverFragmentActivity extends RoboFragmentActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_discover);
	}
}
