package com.example.newlitterfriend.control.activity.register;

import com.example.newlitterfriend.R;
import com.example.newlitterfriend.view.title.TitleBar;
import com.example.newlitterfriend.view.title.TitleBarInterface;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.InjectView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 输入验证码页面
 * 
 * @author Administrator
 * 
 */
public class InputAuthCodeFragmentActivity extends RoboFragmentActivity
		implements TitleBarInterface, OnClickListener {
	/** 标题栏 */
	@InjectView(R.id.inputauthcode_titlebar)
	TitleBar _fTitleBar;
	/** 已经发送提示文本框 */
	@InjectView(R.id.inputauthcode_textview_alreadysend)
	TextView _fAlreadySendTextView;
	/** 验证码输入框 */
	@InjectView(R.id.inputauthcode_exittext_authcode)
	EditText _fAuthCodeEditText;
	/** 重发按钮 */
	@InjectView(R.id.inputauthcode_button_resend)
	Button _fReSendButton;
	/** 下一步按钮 */
	@InjectView(R.id.inputauthcode_button_nextstep)
	Button _fNextStepButton;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_inputauthcode);
		
		_fTitleBar.set_fTitleBarInterface(this);
		
		_fNextStepButton.setOnClickListener(this);
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
		case R.id.inputauthcode_button_nextstep:
			Intent intent = new Intent(this, BindRoleFragmentActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
}
