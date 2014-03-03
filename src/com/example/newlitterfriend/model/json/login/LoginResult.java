package com.example.newlitterfriend.model.json.login;

import com.example.newlitterfriend.model.json.BaseJackSonBean;

/**
 * 登陆结果
 * 
 * @author Administrator
 * 
 */
public class LoginResult extends BaseJackSonBean {
	private Entity entity;

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

}
