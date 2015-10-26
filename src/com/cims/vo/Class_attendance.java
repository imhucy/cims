package com.cims.vo;

import java.util.Date;

//班级考勤类
public class Class_attendance {
	//属性
	private int attendance_id;
	private int class_id;
	private String attendance_address;
	private Date attendance_time;
	private int student_sum;
	private int student_realSum;
	private int notSum;
	//构造方法
	public Class_attendance() {
		
	}
	public Class_attendance(int attendance_id, int class_id,
			String attendance_address, Date attendance_time, int student_sum,
			int student_realSum, int notSum) {
		this();
		setAttendance_id(attendance_id);
		setClass_id(class_id);
		setAttendance_address(attendance_address);
		setAttendance_time(attendance_time);
		setStudent_sum(student_sum);
		setStudent_realSum(student_realSum);
		setNotSum(notSum);
	}
	//get和set方法
	public int getAttendance_id() {
		return attendance_id;
	}
	public void setAttendance_id(int attendance_id) {
		this.attendance_id = attendance_id;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getAttendance_address() {
		return attendance_address;
	}
	public void setAttendance_address(String attendance_address) {
		this.attendance_address = attendance_address;
	}
	public Date getAttendance_time() {
		return attendance_time;
	}
	public void setAttendance_time(Date attendance_time) {
		this.attendance_time = attendance_time;
	}
	public int getStudent_sum() {
		return student_sum;
	}
	public void setStudent_sum(int student_sum) {
		this.student_sum = student_sum;
	}
	public int getStudent_realSum() {
		return student_realSum;
	}
	public void setStudent_realSum(int student_realSum) {
		this.student_realSum = student_realSum;
	}
	public int getNotSum() {
		return notSum;
	}
	public void setNotSum(int notSum) {
		this.notSum = notSum;
	}
	

	
}
