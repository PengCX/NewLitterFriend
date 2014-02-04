package com.example.newlitterfriend.control.activity.launcher;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.InjectView;

import com.example.newlitterfriend.R;
import com.example.newlitterfriend.control.activity.login.LoginFragmentActivity;
import com.example.newlitterfriend.control.activity.register.GetAuthCodeFragmentActivity;
import com.example.newlitterfriend.control.adapter.ExihibitionPagerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

/**
 * 展示页面，该页面用于展示软件最新信息
 * 
 * @author Administrator
 * 
 */
public class ExhibitionFragmentActivity extends RoboFragmentActivity {

	/** 视图引用：ViewPager */
	@InjectView(R.id.exhibition_viewpager_pictures)
	ViewPager _fPicturesViewPager;
	/** 视图引用：登陆按钮 */
	@InjectView(R.id.exhibition_button_login)
	Button _fLoginButton;
	/** 视图引用：注册按钮 */
	@InjectView(R.id.exhibition_button_register)
	Button _fRegisterButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exhibition);

		initPicturesViewPagerShow();
	}

	/**
	 * 初始化图片ViewPager的显示
	 */
	private void initPicturesViewPagerShow() {
		_fPicturesViewPager.setAdapter(new ExihibitionPagerAdapter(
				getSupportFragmentManager()));
	}

	/**
	 * 登陆按钮点击事件
	 * 
	 * @param view
	 *            登陆按钮视图
	 */
	public void turnToLoginPager(View view) {
		Intent intent = new Intent(this, LoginFragmentActivity.class);
		startActivity(intent);
	}

	/**
	 * 注册按钮点击事件
	 * 
	 * @param view
	 *            注册按钮视图
	 */
	public void turnToRegisterPager(View view) {
		Intent intent = new Intent(this, GetAuthCodeFragmentActivity.class);
		startActivity(intent);
	}
}
