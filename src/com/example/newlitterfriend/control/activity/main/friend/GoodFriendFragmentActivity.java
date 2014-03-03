package com.example.newlitterfriend.control.activity.main.friend;

import com.example.newlitterfriend.R;
import com.example.newlitterfriend.control.activity.BaseRoboFragmentActivity;
import com.example.newlitterfriend.control.asynctask.FriendListAsyncTask;
import com.example.newlitterfriend.control.http.PhoneInfo;

import android.os.Bundle;

/**
 * 好友页面
 * 
 * @author Dell
 * 
 */
public class GoodFriendFragmentActivity extends BaseRoboFragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_goodfriend);

		PhoneInfo phoneInfo = new PhoneInfo(this);

		new FriendListAsyncTask(this, false).execute(
				String.valueOf(phoneInfo.getLongitude()),
				String.valueOf(phoneInfo.getLatitude()), "1", "", "", "1");
	}
}
