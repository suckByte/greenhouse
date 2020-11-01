package com.greenhouse.test;

import java.util.HashMap;
import java.util.Map;

/**
 *	新建通用类处理JSON的数据
 * @author Westin IT
 *
 */
public class Message {

	private int code;
	
	private String msg;
	
	private Map<String, Object> extend = new HashMap<String, Object>();
	
	public static Message Success() {
		Message msg = new Message();
		msg.setCode(200);
		msg.setMsg("Success");
		return msg;
	}
	
	public static Message Fail() {
		Message msg = new Message();
		msg.setCode(400);
		msg.setMsg("Failed");
		return msg;
	}
	
	public Message add(String key, Object value) {
		this.extend.put(key, value);
		return this;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
}