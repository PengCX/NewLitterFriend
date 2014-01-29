package com.example.newlitterfriend.control.acitivity.register;

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
 * 注册第三步个人信息页面
 * 
 * @author xiang_000
 * 
 */
public class PersonalInfoFragmentActivity extends RoboFragmentActivity
		implements TitleBarInterface, OnClickListener {
	/** 标题栏 */
	@InjectView(R.id.personalinfo_titlebar)
	TitleBar _fTitleBar;
	/** 完成注册按钮 */
	@InjectView(R.id.personalinfo_button_finish)
	Button _fFinishButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personalinfo);
		_fTitleBar.set_fTitleBarInterface(this);
		_fFinishButton.setOnClickListener(this);
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
		case R.id.personalinfo_button_finish:
			Intent intent = new Intent(this,
					RegisterSuccessFragmentActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
}
