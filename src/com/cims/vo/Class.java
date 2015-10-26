package com.cims.vo;
//�༶��
public class Class {
	private int class_id;
	private String class_name;
	private double sum_money;
	public Class(){
		
	}
	public Class(int class_id, String class_name, double sum_money) {
		setClass_id(class_id);
		setClass_name(class_name);
		setSum_money(sum_money);
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public double getSum_money() {
		return sum_money;
	}
	public void setSum_money(double sum_money) {
		this.sum_money = sum_money;
	}
	
}
