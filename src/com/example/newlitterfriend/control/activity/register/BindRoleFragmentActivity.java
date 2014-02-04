package com.example.newlitterfriend.control.activity.register;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.InjectView;

import com.example.newlitterfriend.R;
import com.example.newlitterfriend.view.title.TitleBar;
import com.example.newlitterfriend.view.title.TitleBarInterface;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 注册第二部绑定角色页面
 * 
 * @author xiang_000
 * 
 */
public class BindRoleFragmentActivity extends RoboFragmentActivity implements
		TitleBarInterface, OnClickListener {
	@InjectView(R.id.bindrole_titlebar)
	TitleBar _fTitleBar;

	@InjectView(R.id.bindrole_button_bind)
	Button _fBindRoleButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bindrole);

		_fTitleBar.set_fTitleBarInterface(this);
		_fBindRoleButton.setOnClickListener(this);
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
		case R.id.bindrole_button_bind:
			Intent intent = new Intent(this, PersonalInfoFragmentActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
}
