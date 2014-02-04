package com.example.newlitterfriend.control.activity.login;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.InjectView;

import com.example.newlitterfriend.R;
import com.example.newlitterfriend.control.activity.main.MainFragmentActivity;
import com.example.newlitterfriend.control.activity.register.GetAuthCodeFragmentActivity;
import com.example.newlitterfriend.view.title.TitleBar;
import com.example.newlitterfriend.view.title.TitleBarInterface;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * 登陆页面
 * 
 * @author Administrator
 * 
 */
public class LoginFragmentActivity extends RoboFragmentActivity implements
		TitleBarInterface, OnClickListener {
	/** 标题栏 */
	@InjectView(R.id.login_titlebar)
	TitleBar _fTitleBar;
	/** 登陆按钮 */
	@InjectView(R.id.login_button_login)
	Button _fLoginButton;
	/** 新用户注册文本 */
	@InjectView(R.id.login_textview_newuserregister)
	TextView _fNewUerRegister;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		_fTitleBar.set_fTitleBarInterface(this);
		_fLoginButton.setOnClickListener(this);
		_fNewUerRegister.setOnClickListener(this);
	}

	@Override
	public void setLeftButtonClick() {
		finish();
	}

	@Override
	public void setRightButtonClick() {

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_button_login:
			Intent intent = new Intent(this, MainFragmentActivity.class);
			startActivity(intent);
			break;
		case R.id.login_textview_newuserregister:
			Intent intent2 = new Intent(this, GetAuthCodeFragmentActivity.class);
			startActivity(intent2);
			break;
		default:
			break;
		}
	}
}
