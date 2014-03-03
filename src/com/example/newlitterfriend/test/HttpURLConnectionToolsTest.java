package com.example.newlitterfriend.test;

import com.example.newlitterfriend.tools.HttpURLConnectionTools;

import android.test.AndroidTestCase;

/**
 * HttpURLConnectionTools测试类
 * 
 * @author Administrator
 * 
 */
public class HttpURLConnectionToolsTest extends AndroidTestCase {

	public void testGetIntenetDateByGET() {
		String result = HttpURLConnectionTools.getIntenetDateByGET();
	}

	public void testGetIntenetDateByPost() {
		String result = HttpURLConnectionTools.getIntenetDateByPost("");
	}
}
