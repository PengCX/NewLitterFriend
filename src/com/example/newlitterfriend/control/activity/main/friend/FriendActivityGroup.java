package com.example.newlitterfriend.control.activity.main.friend;

import roboguice.activity.RoboActivityGroup;
import roboguice.inject.InjectView;

import com.example.newlitterfriend.R;
import com.google.inject.Inject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

/**
 * 朋友页面
 *
 * @author Dell
 *
 */
public class FriendActivityGroup extends RoboActivityGroup {
	/** TabHost对象 */
	@InjectView(android.R.id.tabhost)
	TabHost _fTabHost;

	/** LayoutInflater对象 */
	@Inject
	LayoutInflater _fLayoutInflater;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_friend);

		_fTabHost.setup(getLocalActivityManager());

		_fTabHost.addTab(_fTabHost
				.newTabSpec("goodfriend")
				.setIndicator(
						_fLayoutInflater.inflate(
								R.layout.friend_tab_googlefriend, null))
				.setContent(new Intent(this, GoodFriendFragmentActivity.class)));
		_fTabHost.addTab(_fTabHost
				.newTabSpec("attention")
				.setIndicator(
						_fLayoutInflater.inflate(R.layout.friend_tab_attention,
								null))
				.setContent(new Intent(this, AttentionFragmentActivity.class)));
		_fTabHost.addTab(_fTabHost
				.newTabSpec("fans")
				.setIndicator(
						_fLayoutInflater
								.inflate(R.layout.friend_tab_fans, null))
				.setContent(new Intent(this, FansFragmentActivity.class)));
	}
}
