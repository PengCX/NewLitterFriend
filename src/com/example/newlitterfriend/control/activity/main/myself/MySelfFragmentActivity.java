package com.example.newlitterfriend.control.activity.main.myself;

import roboguice.activity.RoboFragmentActivity;

import com.example.newlitterfriend.R;

import android.os.Bundle;

/**
 * 我页面
 * 
 * @author Dell
 * 
 */
public class MySelfFragmentActivity extends RoboFragmentActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_myself);
	}
}
