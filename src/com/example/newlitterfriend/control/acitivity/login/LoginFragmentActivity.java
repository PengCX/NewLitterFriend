package com.example.newlitterfriend.control.acitivity.login;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.InjectView;

import com.example.newlitterfriend.R;
import com.example.newlitterfriend.view.title.TitleBar;
import com.example.newlitterfriend.view.title.TitleBarInterface;

import android.os.Bundle;

/**
 * 登陆页面
 * 
 * @author Administrator
 * 
 */
public class LoginFragmentActivity extends RoboFragmentActivity implements
		TitleBarInterface {
	/** 视图引用：标题栏 */
	@InjectView(R.id.login_titlebar)
	TitleBar _fTitleBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		_fTitleBar.set_fTitleBarInterface(this);
	}

	@Override
	public void setLeftButtonClick() {
		finish();
	}

	@Override
	public void setRightButtonClick() {

	}
}
