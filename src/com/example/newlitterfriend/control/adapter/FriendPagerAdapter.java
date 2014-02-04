package com.example.newlitterfriend.control.adapter;

import com.example.newlitterfriend.control.activity.main.friend.AttentionFragment;
import com.example.newlitterfriend.control.activity.main.friend.FansFragment;
import com.example.newlitterfriend.control.activity.main.friend.GoodFriendFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * 朋友页面viewPager适配器
 * 
 * @author Dell
 * 
 */
public class FriendPagerAdapter extends FragmentStatePagerAdapter {

	public FriendPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		Fragment fragment = null;

		switch (arg0) {
		case 0:
			fragment = new GoodFriendFragment();
			break;
		case 1:
			fragment = new AttentionFragment();
			break;
		case 2:
			fragment = new FansFragment();
			break;
		default:
			break;
		}

		return fragment;
	}

	@Override
	public int getCount() {
		return 3;
	}

}
