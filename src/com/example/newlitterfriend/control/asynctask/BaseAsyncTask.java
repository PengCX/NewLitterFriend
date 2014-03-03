package com.example.newlitterfriend.control.asynctask;

import com.example.newlitterfriend.model.json.BaseJackSonBean;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * 基本异步任务类：主要实现了联网时候，对话框的显示，和针对不同结果状态的处理
 * 
 * @author Administrator
 * 
 */
public abstract class BaseAsyncTask extends AsyncTask<String, Integer, String> {
	/** 上下文对象 */
	protected Context _fContext;
	/** 解析的结果Json对象 */
	protected BaseJackSonBean _fResultJackSonBean;
	/** 对否显示联网对话框 */
	private Boolean _fIsShowDialog;

	/**
	 * 获取结果Json对象
	 * 
	 * @return 结果Json对象
	 */
	public BaseJackSonBean get_fResultJackSonBean() {
		return _fResultJackSonBean;
	}

	/**
	 * 构造基本的异步任务对象
	 * 
	 * @param aContext
	 *            上下文对象
	 */
	public BaseAsyncTask(Context aContext, Boolean aIsShowDialog) {
		super();
		_fContext = aContext;
		_fIsShowDialog = aIsShowDialog;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		showLinkedNetworkDialog();
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);

		dismissLinkedNetworkDialog();

		if (_fResultJackSonBean != null) {
			handleResultByState(_fResultJackSonBean);
		}
	}

	/**
	 * 显示联网对话框
	 */
	private void showLinkedNetworkDialog() {
		if (_fIsShowDialog) {
			// TODO 显示联网对话框
		}
	}

	/**
	 * 关闭联网对话框
	 */
	private void dismissLinkedNetworkDialog() {
		if (_fIsShowDialog) {
			// TODO取消联网对话框
		}
	}

	/**
	 * 根据不同的结果状态进行处理
	 * 
	 * @param _aResultJackSonBean2
	 */
	protected void handleResultByState(BaseJackSonBean aResultJackSonBean) {
		// 根据不同的结果状态执行不同的处理
		ResultState resultState = aResultJackSonBean.judgeResultState();

		switch (resultState) {
		case SUCCESS:
			handleSuccess(aResultJackSonBean);
			break;
		default:
			break;
		}
	}

	/**
	 * 处理成功的状态，默认显示message消息
	 * 
	 * @param aResultJackSonBean
	 */
	protected void handleSuccess(BaseJackSonBean aResultJackSonBean) {
		Toast.makeText(_fContext, aResultJackSonBean.getErrorcode(),
				Toast.LENGTH_SHORT).show();
	}
}
