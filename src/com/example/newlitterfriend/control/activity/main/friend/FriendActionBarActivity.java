package com.example.newlitterfriend.control.activity.main.friend;

import com.example.newlitterfriend.R;
import com.example.newlitterfriend.control.adapter.FriendPagerAdapter;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar.Tab;

/**
 * 朋友页面
 * 
 * @author Dell
 * 
 */
public class FriendActionBarActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_friend);

		initFriendsViewPagerShow();

		addTabsToActionBar();
	}

	/**
	 * 向ActionBar添加Tabs
	 */
	private void addTabsToActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		ActionBar.TabListener tabListener = new ActionBar.TabListener() {

			@Override
			public void onTabReselected(Tab arg0, FragmentTransaction arg1) {

			}

			@Override
			public void onTabSelected(Tab arg0, FragmentTransaction arg1) {

			}

			@Override
			public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {

			}
		};

		for (int i = 0; i < 3; i++) {
			actionBar.addTab(actionBar.newTab().setText("Tab " + (i + 1))
					.setTabListener(tabListener));
		}

	}

	/**
	 * 初始化朋友页面viewPager显示
	 */
	private void initFriendsViewPagerShow() {
		ViewPager viewPager = (ViewPager) findViewById(R.id.friend_viewpager);
		viewPager
				.setAdapter(new FriendPagerAdapter(getSupportFragmentManager()));
	}
}
