package com.example.newlitterfriend.tools;

import android.util.Log;

/**
 * 日志工具类：可以通过开关控制项目中各种日志的输出
 * 
 * @author xiang_000
 * @since RYC1.0 2013-3-28
 */
public final class LogTools {
	/** 错误输出标识 */
	public static String TAG = "newlitterfirend";

	/** 是否关闭日志信息 */
	public static boolean isLogOff = true;
	/** 是否关闭错误日志 */
	public static boolean isErrorLogOff = true;
	/** 是否关闭警告调制日志 */
	public static boolean isWarnLogOff = true;
	/** 是否关闭信息日志 */
	public static boolean isInfoLogOff = true;
	/** 是否关闭调试日志 */
	public static boolean isDebugLogOff = true;
	/** 是否关闭详细日志 */
	public static boolean isVerboseLogOff = true;
	
	//为了显示Log的模板，方便负责粘贴使用
//	LogTools.showLog(LogTools.TAG, "事件+信息", LogType.INFO);

	/**
	 * 输出日志信息，Tag太长可能无法输出
	 * 
	 * @param aTag
	 *            日志标识
	 * @param aLogMessage
	 *            日志消息
	 * @param aLogStyle
	 *            日志类型
	 */
	public static void showLog(String aTag, String aLogMessage, LogType aLogStyle) {
		//FIXME 使用日志类型区分，建立完整的日志输出体系
		if (isLogOff) {
			switch (aLogStyle) {
				case ERROR:
					if (isErrorLogOff) {
						Log.e(aTag, aLogMessage);
					}
					break;
				case WARN:
					if (isWarnLogOff) {
						Log.w(aTag, aLogMessage);
					}
					break;
				case INFO:
					if (isInfoLogOff) {
						Log.i(aTag, aLogMessage);
					}
					break;
				case DEBUG:
					if (isDebugLogOff) {
						Log.d(aTag, aLogMessage);
					}
					break;
				case VERBOSE:
					if (isVerboseLogOff) {
						Log.v(aTag, aLogMessage);
					}
					break;
				default:
					throw new AssertionError("switch语句中，没有该日志类型新增的分支");
			}
		}
	}
	
	/**
	 * 日志类型枚举
	 * 
	 * @author Administrator
	 * 
	 */
	public enum LogType {
		/** 错误日志 */
		ERROR,
		/** 敬告日志 */
		WARN,
		/** 信息日志:一般的业务逻辑日志输出 */
		INFO,
		/** 调试日志:软件调试的日志输出 */
		DEBUG,
		/** 详细日志*/
		VERBOSE;
	}
}
