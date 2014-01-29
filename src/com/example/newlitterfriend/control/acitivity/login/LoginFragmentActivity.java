package com.example.newlitterfriend.control.acitivity.login;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.InjectView;

import com.example.newlitterfriend.R;
import com.example.newlitterfriend.control.acitivity.main.MainFragmentActivity;
import com.example.newlitterfriend.view.title.TitleBar;
import com.example.newlitterfriend.view.title.TitleBarInterface;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 登陆页面
 * 
 * @author Administrator
 * 
 */
public class LoginFragmentActivity extends RoboFragmentActivity implements
		TitleBarInterface,OnClickListener {
	/** 视图引用：标题栏 */
	@InjectView(R.id.login_titlebar)
	TitleBar _fTitleBar;
	/** 登陆按钮 */
	@InjectView(R.id.login_button_login)
	Button _fLoginButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		_fTitleBar.set_fTitleBarInterface(this);
		_fLoginButton.setOnClickListener(this);
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
			Intent intent = new Intent(this,MainFragmentActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
}
