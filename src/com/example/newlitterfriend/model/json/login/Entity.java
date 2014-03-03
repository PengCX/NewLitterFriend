package com.example.newlitterfriend.model.json.login;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties({ "title", "fansnum", "dynamicmsg", "zannum", "gamelist",
		"user", "characters" })
public class Entity {
	private ChatServer chatServer;
	private Token token;

	public ChatServer getChatServer() {
		return chatServer;
	}

	public void setChatServer(ChatServer chatServer) {
		this.chatServer = chatServer;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

}
