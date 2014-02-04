package com.example.newlitterfriend.control.activity.launcher;

import java.util.Timer;
import java.util.TimerTask;

import roboguice.activity.RoboFragmentActivity;

import com.example.newlitterfriend.R;

import android.os.Bundle;
import android.content.Intent;

/**
 * 程序启动页面
 * 
 * @author Administrator
 * 
 */
public class SplashFragmentActivity extends RoboFragmentActivity {
	/** 启动页面时间 */
	private static final int LAUNCHER_TIME = 1000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		turnToNextActivityAtFixedTime();
	}

	/**
	 * 在指定的时间后跳转下一个页面
	 */
	private void turnToNextActivityAtFixedTime() {
		Timer timer = new Timer();
		timer.schedule(new TurnToNextTimeTask(), LAUNCHER_TIME);
	}

	/**
	 * 跳转下一个页面定时任务类
	 * 
	 * @author Administrator
	 * 
	 */
	class TurnToNextTimeTask extends TimerTask {

		@Override
		public void run() {
			Intent intent = new Intent(SplashFragmentActivity.this,
					ExhibitionFragmentActivity.class);
			startActivity(intent);
		}

	}
}
