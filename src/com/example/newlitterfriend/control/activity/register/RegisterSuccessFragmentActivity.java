package com.example.newlitterfriend.control.activity.register;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.InjectView;

import com.example.newlitterfriend.R;
import com.example.newlitterfriend.control.activity.main.MainActivityGroup;
import com.example.newlitterfriend.view.title.TitleBar;
import com.example.newlitterfriend.view.title.TitleBarInterface;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 注册第四步注册完成页面
 * 
 * @author xiang_000
 * 
 */
public class RegisterSuccessFragmentActivity extends RoboFragmentActivity
		implements TitleBarInterface, OnClickListener {
	/** 标题栏 */
	@InjectView(R.id.registersuccess_titlebar)
	TitleBar _fTitleBar;
	/** 跳转主页面 */
	@InjectView(R.id.registersuccess_button_tomain)
	Button _fToMainButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registersuccess);

		_fTitleBar.set_fTitleBarInterface(this);
		_fToMainButton.setOnClickListener(this);
	}

	@Override
	public void setRightButtonClick() {

	}

	@Override
	public void setLeftButtonClick() {
		finish();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.registersuccess_button_tomain:
			Intent intent = new Intent(this, MainActivityGroup.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
}
