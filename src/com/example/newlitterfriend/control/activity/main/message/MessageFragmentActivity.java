package com.example.newlitterfriend.control.activity.main.message;

import java.util.ArrayList;
import java.util.List;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.InjectView;

import com.example.newlitterfriend.R;
import com.example.newlitterfriend.control.adapter.main.message.RecentlyMessageListAdapter;
import com.example.newlitterfriend.model.bean.MessageInfo;
import com.example.newlitterfriend.model.bean.UserInfo;
import com.example.newlitterfriend.model.bean.main.message.RecentlyMessageInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * 消息页面
 *
 * @author Dell
 *
 */
public class MessageFragmentActivity extends RoboFragmentActivity {
	/** 未读消息列表 */
	@InjectView(R.id.message_listview)
	ListView _fRecentlyMessageListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);

		initRecentlyMessageListShow();
	}

	/**
	 * 初始化最近消息列表的显示
	 */
	private void initRecentlyMessageListShow() {
		List<RecentlyMessageInfo> recentlyMessageInfos = getRecentlyMessageInfos();
		RecentlyMessageListAdapter recentlyMessageListAdapter = new RecentlyMessageListAdapter(
				this, recentlyMessageInfos);
		_fRecentlyMessageListView.setAdapter(recentlyMessageListAdapter);
		_fRecentlyMessageListView.setOnItemClickListener(new RecentlyListItemOnClickListner());
	}

	// 模拟消息数据
	private List<RecentlyMessageInfo> getRecentlyMessageInfos() {
		List<RecentlyMessageInfo> recentlyMessageInfos = new ArrayList<RecentlyMessageInfo>();
		recentlyMessageInfos.add(new RecentlyMessageInfo(new UserInfo("baby",
				"http://user/1.pnd"), new MessageInfo("你好啊", "上午 8:30:23")));
		recentlyMessageInfos.add(new RecentlyMessageInfo(new UserInfo("boy",
				"http://user/1.pnd"),
				new MessageInfo("嘿嘿", "2013-2-30 8:30:23")));
		recentlyMessageInfos.add(new RecentlyMessageInfo(new UserInfo("girl",
				"http://user/1.pnd"), new MessageInfo("呵呵", "下午 8:30:23")));
		recentlyMessageInfos.add(new RecentlyMessageInfo(new UserInfo("woman",
				"http://user/1.pnd"),
				new MessageInfo("哈哈", "2013-4-23 8:30:23")));
		return recentlyMessageInfos;
	}

	/**
	 * 最近消息列表选项点击事件监听器
	 *
	 * @author xiang_000
	 *
	 */
	class RecentlyListItemOnClickListner implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Intent intent = new Intent(MessageFragmentActivity.this, ChatFragmentActivity.class);
			startActivity(intent);
		}
	}
}
