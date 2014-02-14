package com.example.newlitterfriend.control.xmpp;

import java.util.Collection;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;

/**
 * XMPP工具类，使用asmack包，遵循XMMPP协议，与openfire服务器进行通信
 * 
 * @author Administrator
 * 
 */
public class XMPPTools {
	/** 服务器的ip */
	private static final String OPENFIRE_SERVER_IP = "192.168.30.89";
	/** 服务器的端口 */
	private static final int OPENFIRE_SERVER_PORT = 5222;
	/** 服务器的名称 */
	private static final String OPENFIRE_SERVER_NAME = "win-pc";

	private static Connection _fConnection;

	/**
	 * 连接服务器
	 */
	public static void connectedServer() {
		// 开启Debug模式，可以在logcat中查看发送的数据格式
		Connection.DEBUG_ENABLED = true;

		ConnectionConfiguration config = new ConnectionConfiguration(
				OPENFIRE_SERVER_IP, OPENFIRE_SERVER_PORT, OPENFIRE_SERVER_NAME);
		config.setReconnectionAllowed(true);
		config.setCompressionEnabled(true);
		config.setSASLAuthenticationEnabled(true);

		_fConnection = new XMPPConnection(config);

		try {
			_fConnection.connect();
		} catch (XMPPException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 登陆服务器
	 * 
	 * @param aUsername
	 *            用户名
	 * @param aPassword
	 *            密码
	 */
	public static void loginServer(String aUsername, String aPassword) {
		try {
			_fConnection.login(aUsername, aPassword);
		} catch (XMPPException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取所有的好友
	 */
	public static Collection<RosterEntry> getAllFriends() {
		Roster roster = _fConnection.getRoster();
		Collection<RosterEntry> entries = roster.getEntries();
		for (RosterEntry entry : entries) {
			System.out.println(entry);
		}
		return entries;
	}

	/**
	 * 向指定的好友发送消息
	 * 
	 * @param aMessage
	 * @param aFriendName
	 */
	public static void SendMessageToSpecifiedFriend(String aMessage,
			String aFriendName) {
		ChatManager chatmanager = _fConnection.getChatManager();
		Chat newChat = chatmanager.createChat(aFriendName,
				new MessageListener() {
					@Override
					public void processMessage(Chat arg0, Message arg1) {
						System.out.println("Received message: "
								+ arg1.getBody());
					}
				});

		try {
			Message message = new Message();
			message.setBody(aMessage);
			message.setProperty("favoriteColor", "red");
			newChat.sendMessage(aMessage);
		} catch (XMPPException e) {
			System.out.println("Error Delivering block");
		}
	}
}
