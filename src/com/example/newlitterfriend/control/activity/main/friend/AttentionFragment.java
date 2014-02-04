package com.example.newlitterfriend.control.activity.main.friend;

import com.example.newlitterfriend.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import roboguice.fragment.RoboFragment;

/**
 * 关注页面
 * 
 * @author Dell
 * 
 */
public class AttentionFragment extends RoboFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_attention, container, false);
	}
}
