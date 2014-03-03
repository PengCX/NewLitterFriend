package com.example.newlitterfriend.control.watcher;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * 基本的文本监听器，提供默认的实现，避免实现的时候，一大堆的空方法
 * 
 * @author Administrator
 * 
 */
public class BaseTextWatcher implements TextWatcher {

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {

	}

	@Override
	public void afterTextChanged(Editable s) {

	}

}
