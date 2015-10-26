package com.cims.vo;

import java.util.Date;

//班会类
public class Class_meeting {
	//属性
	private int meeting_id;
	private int class_id;
	private String meeting_name;
	private String meeting_address;
	private String meeting_content;
	private Date meeting_time;
	//构造方法
	public Class_meeting() {
		
	}
	public Class_meeting(int meeting_id, int class_id, String meeting_name,
			String meeting_address, String meeting_content, Date meeting_time) {
		this();
		setMeeting_id(meeting_id);
		setClass_id(class_id);
		setMeeting_name(meeting_name);
		setMeeting_address(meeting_address);
		setMeeting_content(meeting_content);
		setMeeting_time(meeting_time);
	}
	//get和set方法
	public int getMeeting_id() {
		return meeting_id;
	}
	public void setMeeting_id(int meeting_id) {
		this.meeting_id = meeting_id;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getMeeting_name() {
		return meeting_name;
	}
	public void setMeeting_name(String meeting_name) {
		this.meeting_name = meeting_name;
	}
	public String getMeeting_address() {
		return meeting_address;
	}
	public void setMeeting_address(String meeting_address) {
		this.meeting_address = meeting_address;
	}
	public String getMeeting_content() {
		return meeting_content;
	}
	public void setMeeting_content(String meeting_content) {
		this.meeting_content = meeting_content;
	}
	public Date getMeeting_time() {
		return meeting_time;
	}
	public void setMeeting_time(Date meeting_time) {
		this.meeting_time = meeting_time;
	}
	
}
