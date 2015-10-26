package com.cims.vo;

import java.util.Date;

//班费类
public class Class_cost {
	//属性
	private int cost_id;
	private int class_id;
	private String cost_name;
	private double cost_number;
	private Date cost_time;
	//构造方法
	public Class_cost() {
		
	}
	public Class_cost(int cost_id, int class_id, String cost_name,
			double cost_number, Date cost_time) {
		this();
		setCost_id(cost_id);
		setClass_id(class_id);
		setCost_name(cost_name);
		setCost_number(cost_number);
		setCost_time(cost_time);
	}
	//get和set方法
	public int getCost_id() {
		return cost_id;
	}
	public void setCost_id(int cost_id) {
		this.cost_id = cost_id;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getCost_name() {
		return cost_name;
	}
	public void setCost_name(String cost_name) {
		this.cost_name = cost_name;
	}
	public double getCost_number() {
		return cost_number;
	}
	public void setCost_number(double cost_number) {
		this.cost_number = cost_number;
	}
	public Date getCost_time() {
		return cost_time;
	}
	public void setCost_time(Date cost_time) {
		this.cost_time = cost_time;
	}
	
}
