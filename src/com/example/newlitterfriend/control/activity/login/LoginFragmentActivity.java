package com.example.newlitterfriend.control.activity.login;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.InjectView;

import com.example.newlitterfriend.R;
import com.example.newlitterfriend.control.activity.BaseRoboFragmentActivity;
import com.example.newlitterfriend.control.activity.main.MainActivityGroup;
import com.example.newlitterfriend.control.activity.register.GetAuthCodeFragmentActivity;
import com.example.newlitterfriend.control.asynctask.LoginAsyncTask;
import com.example.newlitterfriend.control.http.SoftWareInfo;
import com.example.newlitterfriend.control.watcher.BaseTextWatcher;
import com.example.newlitterfriend.model.bean.login.UserInfo;
import com.example.newlitterfriend.model.exception.login.PasswordFormatErrorException;
import com.example.newlitterfriend.model.exception.login.PhoneNumberFormatErrorException;
import com.example.newlitterfriend.model.json.BaseJackSonBean;
import com.example.newlitterfriend.model.json.login.LoginResult;
import com.example.newlitterfriend.view.title.TitleBar;
import com.example.newlitterfriend.view.title.TitleBarInterface;
import com.google.inject.Inject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 登陆页面
 * 
 * @author Administrator
 * 
 */
public class LoginFragmentActivity extends BaseRoboFragmentActivity implements
		TitleBarInterface {
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

	/** 用户登录信息 */
	@Inject
	UserInfo _fUserInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		_fTitleBar.set_fTitleBarInterface(this);

		_fLoginButton.setOnClickListener(new ButtonClick());
		_fNewUerRegister.setOnClickListener(new ButtonClick());

		_fPhoneNumberEditText
				.addTextChangedListener(new PhoneEditTextWatcher());
		_fPassWordEditText.addTextChangedListener(new PasswordEditTextWather());
	}

	@Override
	public void setLeftButtonClick() {
		finish();
	}

	@Override
	public void setRightButtonClick() {

	}

	/**
	 * 按钮点击事件监听
	 * 
	 * @author Administrator
	 * 
	 */
	class ButtonClick implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.login_button_login:
				try {
					new LoginAsyncTask(LoginFragmentActivity.this, false)
							.execute(_fUserInfo.getPhoneNumber(),
									_fUserInfo.getPassWord());
				} catch (PhoneNumberFormatErrorException e) {
					// 手机号码格式错误
					e.printStackTrace();
					Toast.makeText(LoginFragmentActivity.this, e.getMessage(),
							Toast.LENGTH_SHORT).show();
				} catch (PasswordFormatErrorException e) {
					// 密码格式错误
					e.printStackTrace();
					Toast.makeText(LoginFragmentActivity.this, e.getMessage(),
							Toast.LENGTH_SHORT).show();
				}

				break;
			case R.id.login_textview_newuserregister:
				startActivity(GetAuthCodeFragmentActivity.class);
				break;
			default:
				break;
			}
		}
	}

	/**
	 * 处理登陆异步任务成功
	 * 
	 * @param aResultJackSonBean
	 */
	public void handleLoginAsyncTaskSuccess(BaseJackSonBean aResultJackSonBean) {
		SoftWareInfo.TOKEN_ID = ((LoginResult) aResultJackSonBean).getEntity()
				.getToken().getToken();
		startActivity(MainActivityGroup.class);
	}

	/**
	 * 手机号文本框文本监听器
	 * 
	 * @author Administrator
	 * 
	 */
	class PhoneEditTextWatcher extends BaseTextWatcher {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			_fUserInfo.set_fPhoneNumber(s.toString());
		}

	}

	/**
	 * 密码文本框监听器
	 * 
	 * @author Administrator
	 * 
	 */
	class PasswordEditTextWather extends BaseTextWatcher {
		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			_fUserInfo.set_fPassWord(s.toString());
		}
	}

}
