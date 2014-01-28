package com.example.newlitterfriend.view.title;

import com.example.newlitterfriend.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 标题栏控件
 * 
 * @author Administrator
 * 
 */
public class TitleBar extends RelativeLayout {
	/** 上下文对象 */
	protected Context _fContext;

	/** 左侧按钮 */
	private ImageButton _fLeftButton;
	/** 中间标题 */
	private TextView _fTitleTextView;
	/** 右侧按钮 */
	private ImageButton _fRightButton;

	/** 左侧按钮图片id */
	private int _fLeftButtonDrawableId;
	/** 中间标题字符串id */
	private int _fTitleStringId;
	/** 右侧按钮图片id */
	private int _fRightButtonDrawableId;

	/** 标题接口 */
	private TitleBarInterface _fTitleBarInterface;

	// 初始化代码块，初始化标题栏根相对布局的属性
	{
		setBackgroundResource(R.drawable.titlebar_background);
	}

	/**
	 * 设置标题栏接口实例
	 * 
	 * @param aTitleBarInterface
	 *            标题栏接口实例
	 */
	public void set_fTitleBarInterface(TitleBarInterface aTitleBarInterface) {
		this._fTitleBarInterface = aTitleBarInterface;
	}

	/**
	 * 构造方法
	 * 
	 * @param aContext
	 *            上下文对象
	 * @param aAttributeSet
	 *            属性对象
	 */
	public TitleBar(Context aContext, AttributeSet aAttributeSet) {
		super(aContext, aAttributeSet);
		_fContext = aContext;

		inflaterTitleBarLayout(aContext);

		getCustomDefineAttributes(aAttributeSet);

		initTitleBarShow();
	}

	/**
	 * 解析标题栏布局
	 * 
	 * @param aContext
	 */
	private void inflaterTitleBarLayout(Context aContext) {
		// 获取标题栏布局
		LayoutInflater layoutInflater = (LayoutInflater) aContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		/**
		 * inflate方法说明：第一个参数resource:是指填充的布局资源id,第二个参数root:是resource布局填充到的根布局。
		 * 相关解释：在这里为设置为root为本身this，将title_bar中的视图以TitleBar（继承RelativeLayout）
		 * 自身为根视图填充， 并且在title_bar布局中使用merge标签，避免深的视图结构。
		 */
		layoutInflater.inflate(R.layout.title_bar, this);

		_fLeftButton = (ImageButton) findViewById(R.id.titlebar_imagebutton_left);
		_fTitleTextView = (TextView) findViewById(R.id.titlebar_textview_title);
		_fRightButton = (ImageButton) findViewById(R.id.titlebar_imagebutton_right);
	}

	/**
	 * 获取自定义属相
	 * 
	 * @param aAttributeSet
	 */
	private void getCustomDefineAttributes(AttributeSet aAttributeSet) {
		// 获取自定义属性
		TypedArray typedArray = _fContext.getTheme().obtainStyledAttributes(
				aAttributeSet, R.styleable.TitleBar, 0, 0);
		try {
			// 左侧按钮图片
			_fLeftButtonDrawableId = typedArray.getResourceId(
					R.styleable.TitleBar__fLeftButtonDrawableId, -1);
			// 标题文本
			_fTitleStringId = typedArray.getResourceId(
					R.styleable.TitleBar__fTitleStringId, -1);
			// 右侧按钮图片
			_fRightButtonDrawableId = typedArray.getResourceId(
					R.styleable.TitleBar__fRightButtonDrawableId, -1);
		} finally {
			typedArray.recycle();
		}
	}

	/**
	 * 初始化标题栏显示
	 */
	private void initTitleBarShow() {
		_fTitleTextView.setText(_fTitleStringId);

		if (_fLeftButtonDrawableId != -1) {
			_fLeftButton.setVisibility(View.VISIBLE);
			_fLeftButton.setBackgroundResource(_fLeftButtonDrawableId);
			_fLeftButton
					.setOnClickListener(new TitleBarButtonOnClickListener());

		}

		if (_fRightButtonDrawableId != -1) {
			_fRightButton.setVisibility(View.VISIBLE);
			_fRightButton.setBackgroundResource(_fRightButtonDrawableId);
			_fRightButton
					.setOnClickListener(new TitleBarButtonOnClickListener());
		}
	}

	/**
	 * 标题栏按钮点击事件监听器
	 * 
	 * @author Administrator
	 * @since RYC1.0 2013-10-23
	 */
	class TitleBarButtonOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.titlebar_imagebutton_left:
				_fTitleBarInterface.setLeftButtonClick();
				break;
			case R.id.titlebar_imagebutton_right:
				// 右按钮
				_fTitleBarInterface.setRightButtonClick();
				break;

			default:
				// 抛出AssertionError错误，当新的按钮添加事件监听时候，忘记处理该按钮，switch语句跳到default语句排除错误提示，易于寻找代码错误。
				throw new AssertionError("标题栏按钮点击事件监听时，没有处理id为：" + v.getId()
						+ "按钮的事件。");
			}
		}
	}
}
