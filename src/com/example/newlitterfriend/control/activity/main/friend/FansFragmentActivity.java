package com.example.newlitterfriend.control.activity.main.friend;

import com.example.newlitterfriend.R;

import android.os.Bundle;
import roboguice.activity.RoboFragmentActivity;

/**
 * 粉丝页面
 *
 * @author Dell
 *
 */
public class FansFragmentActivity extends RoboFragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fans);
	}
}
