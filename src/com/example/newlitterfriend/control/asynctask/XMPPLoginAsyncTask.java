package com.example.newlitterfriend.control.asynctask;

import com.example.newlitterfriend.control.activity.main.MainActivityGroup;
import com.example.newlitterfriend.control.xmpp.XMPPTools;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

/**
 * XMPP登陆异步任务
 * 
 * @author Administrator
 * 
 */
public class XMPPLoginAsyncTask extends AsyncTask<String, Integer, String> {
	private Context _fContext;

	public XMPPLoginAsyncTask(Context aContext) {
		super();
		_fContext = aContext;
	}

	@Override
	protected String doInBackground(String... params) {
		String userName = params[0];
		String passWord = params[1];

		XMPPTools.loginServer(userName, passWord);

		return "";
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);

		Intent intent = new Intent(_fContext, MainActivityGroup.class);
		_fContext.startActivity(intent);
	}
}
