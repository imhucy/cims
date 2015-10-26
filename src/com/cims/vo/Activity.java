package com.cims.vo;

import java.util.Date;

//班级活动类
public class Activity {
	//属性
	private int activity_id;
	private int class_id;
	private String activity_name;
	private String activity_address;
	private Date activity_time;
	private String activity_content;
	//构造方法
	public Activity() {
		
	}
	public Activity(int activity_id, int class_id, String activity_name,
			String activity_address, Date activity_time, String activity_content) {
		this();
		setActivity_id(activity_id);
		setClass_id(class_id);
		setActivity_name(activity_name);
		setActivity_address(activity_address);
		setActivity_time(activity_time);
		setActivity_content(activity_content);
	}
	//get和set方法
	public int getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(int activity_id) {
		this.activity_id = activity_id;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getActivity_name() {
		return activity_name;
	}
	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}
	public String getActivity_address() {
		return activity_address;
	}
	public void setActivity_address(String activity_address) {
		this.activity_address = activity_address;
	}
	public Date getActivity_time() {
		return activity_time;
	}
	public void setActivity_time(Date activity_time) {
		this.activity_time = activity_time;
	}
	public String getActivity_content() {
		return activity_content;
	}
	public void setActivity_content(String activity_content) {
		this.activity_content = activity_content;
	}
	
}
