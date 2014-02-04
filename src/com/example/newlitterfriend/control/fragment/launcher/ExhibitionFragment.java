package com.example.newlitterfriend.control.fragment.launcher;

import roboguice.fragment.RoboFragment;

import com.example.newlitterfriend.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 滑动页面子页面
 * 
 * @author Administrator
 * 
 */
public class ExhibitionFragment extends RoboFragment {
	/** 传递图片索引参数key */
	public static final String PICTURE_INDEX = "pictureindex";
	/** 图片的数目 */
	public static final int PICTURE_NUM = 5;

	/** 图片资源数组 */
	private int[] _fPicturesIds = { R.drawable.exhibition_picture1,
			R.drawable.exhibition_picture2, R.drawable.exhibition_picture3,
			R.drawable.exhibition_picture4, R.drawable.exhibition_picture5 };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_exhibition,
				container, false);

		// 设置显示的图片
		Bundle args = getArguments();
		rootView.findViewById(R.id.exhibition_imageview_picture)
				.setBackgroundResource(
						_fPicturesIds[args.getInt(PICTURE_INDEX)]);
		return rootView;
	}
}
