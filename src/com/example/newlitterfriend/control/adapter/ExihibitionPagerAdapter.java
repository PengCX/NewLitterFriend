package com.example.newlitterfriend.control.adapter;

import com.example.newlitterfriend.control.fragment.launcher.ExhibitionFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * 展示ViewPager
 * 
 * @author Administrator
 * 
 */
public class ExihibitionPagerAdapter extends FragmentStatePagerAdapter {

	public ExihibitionPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		Fragment fragment = new ExhibitionFragment();

		// 传递显示的图片索引
		Bundle args = new Bundle();
		args.putInt(ExhibitionFragment.PICTURE_INDEX, arg0);
		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public int getCount() {
		return ExhibitionFragment.PICTURE_NUM;
	}

}
