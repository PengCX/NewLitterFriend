package com.example.newlitterfriend.control.asynctask;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.example.newlitterfriend.control.activity.login.LoginFragmentActivity;
import com.example.newlitterfriend.control.http.login.LoginHttpInterface;
import com.example.newlitterfriend.model.json.BaseJackSonBean;
import com.example.newlitterfriend.model.json.login.LoginResult;

import android.content.Context;

/**
 * 登陆异步任务
 * 
 * @author Administrator
 * 
 */
public class LoginAsyncTask extends BaseAsyncTask {
	/**上下文对象*/
	private Context _fContext;
	

	public LoginAsyncTask(Context aContext, Boolean aIsShowDialog) {
		super(aContext, aIsShowDialog);
		_fContext = aContext;
	}

	@Override
	protected String doInBackground(String... params) {
		String userName = params[0];
		String passWord = params[1];

		String resultJsonString = new LoginHttpInterface(_fContext, userName,
				passWord).getJsonObjectStringFromIntenet();

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			_fResultJackSonBean = objectMapper.readValue(resultJsonString,
					LoginResult.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultJsonString;
	}

	@Override
	protected void handleSuccess(BaseJackSonBean aResultJackSonBean) {
		((LoginFragmentActivity)_fContext).handleLoginAsyncTaskSuccess(aResultJackSonBean);
	}

}
