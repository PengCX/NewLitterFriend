package com.example.newlitterfriend.control.http.main.friend;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.example.newlitterfriend.control.http.BaseHttpInterface;

/**
 * 获取好友列表接口
 * 
 * @author Administrator
 * 
 */
public class FriendListHttpInterface extends BaseHttpInterface {
	/** 经度 */
	private String _fLongitude;
	/** 纬度 */
	private String _fLatitude;
	/** 好友类型 */
	private String _fShiptype;
	private String _fMaxSize;
	private String _fPageIndex;
	/** 排序方式 */
	private String _fSorttype;

	public FriendListHttpInterface(Context aContext, String aLongitude,
			String aLatitude, String aShiptype, String aMaxSize,
			String aPageIndex, String aSorttype) {
		super(aContext);
		_fLongitude = aLongitude;
		_fLatitude = aLatitude;
		_fShiptype = aShiptype;
		_fMaxSize = aMaxSize;
		_fPageIndex = aPageIndex;
		_fSorttype = aSorttype;
	}

	@Override
	public void setParticularParamerters(JSONObject aSubParamtersJsonObject) {
		try {
			aSubParamtersJsonObject.put("longitude", _fLongitude);
			aSubParamtersJsonObject.put("latitude", _fLatitude);
			aSubParamtersJsonObject.put("shiptype", _fShiptype);
			aSubParamtersJsonObject.put("maxSize", _fMaxSize);
			aSubParamtersJsonObject.put("pageIndex", _fPageIndex);
			aSubParamtersJsonObject.put("sorttype", _fSorttype);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void setMethodDefaultParamsters(JSONObject aParamtersJsonObject) {
		try {
			aParamtersJsonObject.put("method", "111");
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
