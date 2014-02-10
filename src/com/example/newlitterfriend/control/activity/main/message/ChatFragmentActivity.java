package com.example.newlitterfriend.control.activity.main.message;

import com.example.newlitterfriend.R;

import android.os.Bundle;
import roboguice.activity.RoboFragmentActivity;

/**
 * 聊天页面
 *
 * @author xiang_000
 *
 */
public class ChatFragmentActivity extends RoboFragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
	}
}
