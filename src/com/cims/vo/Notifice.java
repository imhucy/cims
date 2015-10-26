package com.cims.vo;

import java.util.Date;

//通知类
public class Notifice {
	//属性
	private int notifice_id;
	private int class_id;
	private String notifice_name;
	private String notifice_content;
	private Date notifice_time;
	//构造方法
	public Notifice() {
	
	}
	public Notifice(int notifice_id, int class_id, String notifice_name,
			String notifice_content,Date notifice_time) {
		this();
		setNotifice_id(notifice_id);
		setClass_id(class_id);
		setNotifice_name(notifice_name);
		setNotifice_content(notifice_content);
		setNotifice_time(notifice_time);
	}
	//get和set方法
	
	public int getNotifice_id() {
		return notifice_id;
	}
	public Date getNotifice_time() {
		return notifice_time;
	}
	public void setNotifice_time(Date notifice_time) {
		this.notifice_time = notifice_time;
	}
	public void setNotifice_id(int notifice_id) {
		this.notifice_id = notifice_id;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getNotifice_name() {
		return notifice_name;
	}
	public void setNotifice_name(String notifice_name) {
		this.notifice_name = notifice_name;
	}
	public String getNotifice_content() {
		return notifice_content;
	}
	public void setNotifice_content(String notifice_content) {
		this.notifice_content = notifice_content;
	}
	
}
