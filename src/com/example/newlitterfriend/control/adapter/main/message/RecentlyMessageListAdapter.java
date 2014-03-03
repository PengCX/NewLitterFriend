//package com.example.newlitterfriend.control.adapter.main.message;
//
//import java.util.List;
//
//import com.example.newlitterfriend.R;
//import com.example.newlitterfriend.model.bean.main.message.RecentlyMessageInfo;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
///**
// * 消息列表适配器
// *
// * @author xiang_000
// *
// */
//public class RecentlyMessageListAdapter extends BaseAdapter {
//	/** 上下文对象 */
//	private Context _fContext;
//	/** 最近消息列表 */
//	private List<RecentlyMessageInfo> _fRecentlyMessageInfos;
//
//	public RecentlyMessageListAdapter(Context aContext,
//			List<RecentlyMessageInfo> aRecentlyMessageInfos) {
//		super();
//		_fContext = aContext;
//		_fRecentlyMessageInfos = aRecentlyMessageInfos;
//	}
//
//	@Override
//	public int getCount() {
//		return _fRecentlyMessageInfos.size();
//	}
//
//	@Override
//	public Object getItem(int position) {
//		return _fRecentlyMessageInfos.get(position);
//	}
//
//	@Override
//	public long getItemId(int position) {
//		return position;
//	}
//
//	@Override
//	public View getView(int position, View convertView, ViewGroup parent) {
//		ViewHolder viewHolder;
//
//		if (convertView == null) {
//			viewHolder = new ViewHolder();
//			LayoutInflater layoutInflater = LayoutInflater.from(_fContext);
//			convertView = layoutInflater.inflate(
//					R.layout.recentlymessage_listview_item, null);
//
//			viewHolder._fUserIconImageView = (ImageView) convertView
//					.findViewById(R.id.recentlymessage_listitem_imageview_usericon);
//			viewHolder._fUserNameTextView = (TextView) convertView
//					.findViewById(R.id.recentlymessage_listitem_textview_username);
//			viewHolder._fMessageTextView = (TextView) convertView
//					.findViewById(R.id.recentlymessage_listitem_textview_message);
//			viewHolder._fReceivedTimeTextView = (TextView) convertView
//					.findViewById(R.id.recentlymessage_listitem_textview_recivetime);
//
//			convertView.setTag(viewHolder);
//		} else {
//			viewHolder = (ViewHolder) convertView.getTag();
//		}
//
//		RecentlyMessageInfo recentlyMessageInfo = _fRecentlyMessageInfos
//				.get(position);
//		viewHolder._fUserIconImageView
//				.setBackgroundResource(R.drawable.recentlymessage_listitem_goodfriendrecommend);
//		viewHolder._fUserNameTextView.setText(recentlyMessageInfo
//				.get_fUserInfo().get_fName());
//		viewHolder._fMessageTextView.setText(recentlyMessageInfo
//				.get_fMessageInfo().get_fMessage());
//		viewHolder._fReceivedTimeTextView.setText(recentlyMessageInfo
//				.get_fMessageInfo().get_fRecivedTime());
//
//		return convertView;
//	}
//
//	static class ViewHolder {
//		/** 用户头像 */
//		private ImageView _fUserIconImageView;
//		/** 用户名称 */
//		private TextView _fUserNameTextView;
//		/** 消息 */
//		private TextView _fMessageTextView;
//		/** 接收时间 */
//		private TextView _fReceivedTimeTextView;
//	}
//}
