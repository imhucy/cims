package com.cims.dao;

import java.util.List;

import com.cims.vo.Class_attendance;

public interface IClass_attendanceDAO {
	//录入信息
	public boolean doAdd(Class_attendance class_attendance) throws Exception;
	//修改信息
	public boolean doUpdateInfo(Class_attendance class_attendance,int attendance_id) throws Exception;
	//通过班级考勤班id查看信息
	public List<Class_attendance> findAll(String  keyword) throws Exception;
	//查找关键字
	public  Class_attendance findByld(int class_id) throws Exception;
}
