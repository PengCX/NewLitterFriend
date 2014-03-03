package com.example.newlitterfriend.control.asynctask;

import com.example.newlitterfriend.control.http.main.friend.FriendListHttpInterface;

import android.content.Context;

/**
 * 好友列表异步任务
 * 
 * @author Administrator
 * 
 */
public class FriendListAsyncTask extends BaseAsyncTask {

	public FriendListAsyncTask(Context aContext, Boolean aIsShowDialog) {
		super(aContext, aIsShowDialog);
	}

	@Override
	protected String doInBackground(String... params) {
		String longitude = params[0];
		String latitude = params[1];
		String shiptype = params[2];
		String maxSize = params[3];
		String pageIndex = params[4];
		String sorttype = params[5];

		String resultJsonString = new FriendListHttpInterface(_fContext,
				longitude, latitude, shiptype, maxSize, pageIndex, sorttype)
				.getJsonObjectStringFromIntenet();
		
		
		return null;
	}

}
