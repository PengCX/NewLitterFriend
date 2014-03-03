package com.example.newlitterfriend.control.activity.main;

import com.example.newlitterfriend.R;
import com.example.newlitterfriend.control.activity.main.discover.DiscoverFragmentActivity;
import com.example.newlitterfriend.control.activity.main.friend.FriendActivityGroup;
import com.example.newlitterfriend.control.activity.main.message.MessageFragmentActivity;
import com.example.newlitterfriend.control.activity.main.myself.MySelfFragmentActivity;
import com.google.inject.Inject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;
import roboguice.activity.RoboActivityGroup;
import roboguice.inject.InjectView;

/**
 * 主界面
 * 
 * @author Administrator
 * 
 */
public class MainActivityGroup extends RoboActivityGroup {
	/** TabHost对象 */
	@InjectView(android.R.id.tabhost)
	TabHost _fTabHost;

	/** LayoutInflater对象 */
	@Inject
	LayoutInflater _fLayoutInflater;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initTabHostShow();
	}

	/**
	 * 初始化选项卡显示
	 */
	private void initTabHostShow() {
		_fTabHost.setup(getLocalActivityManager());

		_fTabHost.addTab(_fTabHost
				.newTabSpec("message")
				.setIndicator(
						_fLayoutInflater.inflate(R.layout.main_tab_message,
								null))
				.setContent(new Intent(this, MessageFragmentActivity.class)));
		_fTabHost.addTab(_fTabHost
				.newTabSpec("friend")
				.setIndicator(
						_fLayoutInflater
								.inflate(R.layout.main_tab_friend, null))
				.setContent(new Intent(this, FriendActivityGroup.class)));
		_fTabHost.addTab(_fTabHost
				.newTabSpec("discover")
				.setIndicator(
						_fLayoutInflater.inflate(R.layout.main_tab_discover,
								null))
				.setContent(new Intent(this, DiscoverFragmentActivity.class)));
		_fTabHost.addTab(_fTabHost
				.newTabSpec("myself")
				.setIndicator(
						_fLayoutInflater
								.inflate(R.layout.main_tab_myself, null))
				.setContent(new Intent(this, MySelfFragmentActivity.class)));
	}
}
