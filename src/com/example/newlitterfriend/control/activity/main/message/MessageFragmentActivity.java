package com.example.newlitterfriend.control.activity.main.message;

import roboguice.activity.RoboFragmentActivity;

import com.example.newlitterfriend.R;

import android.os.Bundle;

/**
 * 消息页面
 * 
 * @author Dell
 * 
 */
public class MessageFragmentActivity extends RoboFragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_message);
	}

}
