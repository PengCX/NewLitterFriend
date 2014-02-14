package com.example.newlitterfriend.control.activity.login;

import java.util.UUID;

import org.json.JSONObject;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.InjectView;

import com.example.newlitterfriend.R;
import com.example.newlitterfriend.control.activity.register.GetAuthCodeFragmentActivity;
import com.example.newlitterfriend.control.http.NewLitterFriendClient;
import com.example.newlitterfriend.view.title.TitleBar;
import com.example.newlitterfriend.view.title.TitleBarInterface;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
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
	/** 手机号 */
	@InjectView(R.id.login_edittext_phonenumber)
	EditText _fPhoneNumberEditText;
	/** 密码 */
	@InjectView(R.id.login_edittext_password)
	EditText _fPassWordEditText;

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
			String phoneNumber = _fPhoneNumberEditText.getText().toString();
			String passWord = _fPassWordEditText.getText().toString();

			RequestParams params = new RequestParams();
			// 共同的参数
			params.put("method", "101");
			params.put("channel", "14");
			params.put("token", "");
			params.put("sn", getUUIDStr());
			params.put("encrypt", "false");
			params.put("compression", "false");
			params.put("version", "1.0.0");
			params.put("mac", getMac());
			params.put("imei", getIMEI());

			// 特殊的参数
			RequestParams subParams = new RequestParams();
			subParams.put("username", "13501141025");
			subParams.put("password", "111111");
			params.put("params", subParams);

			NewLitterFriendClient.post(NewLitterFriendClient.URL_POST, params,
					new JsonHttpResponseHandler() {
						@Override
						public void onSuccess(JSONObject response) {
							super.onSuccess(response);
						}
					});

			break;
		case R.id.login_textview_newuserregister:
			Intent intent2 = new Intent(this, GetAuthCodeFragmentActivity.class);
			startActivity(intent2);
			break;
		default:
			break;
		}
	}

	public String getUUIDStr() {
		UUID uuid = UUID.randomUUID();
		String uuidstr = uuid.toString();
		return uuidstr;
	}

	public String getMac() {
		WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		WifiInfo info = wifi.getConnectionInfo();
		return info.getMacAddress();
	}

	public String getIMEI() {
		String Imei = ((TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE))
				.getDeviceId();
		return Imei;
	}
}
