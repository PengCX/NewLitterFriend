package com.example.newlitterfriend.control.acitivity.register;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.InjectView;

import com.example.newlitterfriend.R;
import com.example.newlitterfriend.view.title.TitleBar;
import com.example.newlitterfriend.view.title.TitleBarInterface;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 注册第一步获取验证码页面
 * 
 * @author xiang_000
 * 
 */
public class GetAuthCodeFragmentActivity extends RoboFragmentActivity implements
		TitleBarInterface, OnClickListener {
	/** 标题栏 */
	@InjectView(R.id.getauthcode_titlebar)
	TitleBar _fTitleBar;
	/* 手机号码输入框 */
	@InjectView(R.id.getauthcode_exittext_phonenumber)
	EditText _fPhoneNumberEditText;
	/** 是否同意多选按钮 */
	@InjectView(R.id.getauthcode_checkbox_isagree)
	CheckBox _fIsAgreeCheckBox;
	/** 协议文本框 */
	@InjectView(R.id.getauthcode_textview_protocol)
	TextView _fProtocolTextView;
	/** 获取验证码按钮 */
	@InjectView(R.id.getauthcode_button_getauthcode)
	Button _fGetAuthCodeButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_getauthcode);

		_fTitleBar.set_fTitleBarInterface(this);
		
		_fProtocolTextView.setText(Html
				.fromHtml("<font color=red>阅读并同意</font>用户协议"));
		
		_fGetAuthCodeButton.setOnClickListener(this);
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
		case R.id.getauthcode_button_getauthcode:
			Intent intent = new Intent(this, InputAuthCodeFragmentActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}
}
