package com.example.newlitterfriend.control.acitivity.main;

import com.example.newlitterfriend.R;

import android.os.Bundle;
import roboguice.activity.RoboFragmentActivity;

/**
 * 主界面
 * 
 * @author Administrator
 * 
 */
public class MainFragmentActivity extends RoboFragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

}
