package com.example.newlitterfriend.view.list;

import com.example.newlitterfriend.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 分组索引列表：实现分组显示，索引滑动的列表效果
 * 
 * @author Administrator
 * 
 */
public class GroupIndexListView extends FrameLayout {
	/** 上下文对象 */
	private Context _fContext;

	/** 列表 */
	private ListView _fListView;
	/** 索引 */
	private TextView _fIndexTextView;
	/** 索引条容器 */
	private LinearLayout _fIndexLinearLayout;

	public GroupIndexListView(Context aContext, AttributeSet aAttrs) {
		super(aContext, aAttrs);
		_fContext = aContext;

		inflaterGroupIndexListViewLayout(aContext);

		initGroupIndexListViewShow();
	}

	/**
	 * 初始化分组列表的显示
	 */
	private void initGroupIndexListViewShow() {
		
	}

	private void inflaterGroupIndexListViewLayout(Context aContext) {
		// 获取标题栏布局
		LayoutInflater layoutInflater = (LayoutInflater) aContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		/**
		 * inflate方法说明：第一个参数resource:是指填充的布局资源id,第二个参数root:是resource布局填充到的根布局。
		 * 相关解释：在这里为设置为root为本身this，将title_bar中的视图以TitleBar（继承RelativeLayout）
		 * 自身为根视图填充， 并且在title_bar布局中使用merge标签，避免深的视图结构。
		 */
		layoutInflater.inflate(R.layout.groupindex_listview, this);

		_fListView = (ListView) findViewById(R.id.groupindex_listview_listview);
		_fIndexTextView = (TextView) findViewById(R.id.groudindex_textview_index);
		_fIndexLinearLayout = (LinearLayout) findViewById(R.id.groupindex_linearlayout_indexbar);
	}

	/**
	 * 设置适配器
	 * 
	 * @param aBaseAdapter
	 */
	public void setAdapter(BaseAdapter aBaseAdapter) {

	}
}
