package com.cims.vo;

import java.util.Date;

//ѧ����
public class Student {
	//����
	private int student_id;
	private int class_id;
	private String student_sex;
	private Date student_birthday;
	private String student_name;
	private String telephone;
	private String password;
	private int posion;
	//���췽��
	public Student() {
		
	}
	
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", class_id=" + class_id
				+ ", student_sex=" + student_sex + ", student_birthday="
				+ student_birthday + ", student_name=" + student_name
				+ ", telephone=" + telephone + ", password=" + password
				+ ", posion=" + posion + "]";
	}

	public Student(int student_id, int class_id, String student_sex,
			Date student_birthday, String student_name, String telephone,
			String password, int posion) {
		this();
		setStudent_id(student_id);
		setClass_id(class_id);
		setStudent_sex(student_sex);
		setStudent_birthday(student_birthday);
		setStudent_name(student_name);
		setTelephone(telephone);
		setPassword(password);
		setPosion(posion);
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getStudent_sex() {
		return student_sex;
	}
	public void setStudent_sex(String student_sex) {
		this.student_sex = student_sex;
	}
	public Date getStudent_birthday() {
		return student_birthday;
	}
	public void setStudent_birthday(Date student_birthday) {
		this.student_birthday = student_birthday;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPosion() {
		return posion;
	}
	public void setPosion(int posion) {
		this.posion = posion;
	}
	
	
}
