package com.cims.dao;

import java.util.List;

import com.cims.vo.Stu_attendance;

public interface IStu_attendanceDAO {
	// 添加考勤记录
	public boolean doAdd(Stu_attendance stu_attendance) throws Exception;
	// 按班级查询所有的考勤记录
	public List<Stu_attendance> findAll(int class_id)throws Exception;
	//	按id查询
	public Stu_attendance findById(int attendance_id) throws Exception;
	// 更新考勤记录
	public boolean doUpdateAttendance(Stu_attendance stu_attendance) throws Exception;
	
}
