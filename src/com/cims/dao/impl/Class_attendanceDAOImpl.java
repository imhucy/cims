package com.cims.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cims.dao.IClass_attendanceDAO;
import com.cims.vo.Class_attendance;

public class Class_attendanceDAOImpl implements IClass_attendanceDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public Class_attendanceDAOImpl(Connection conn){
		this.conn = conn;
	}
	
	public boolean doAdd(Class_attendance class_attendance) throws Exception {
		boolean flag = false;
		String sql = "insert into Class_attendance values(?,?,?,?,?,?,?)";
		
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, class_attendance.getAttendance_id());
		this.pstmt.setInt(2, class_attendance.getClass_id());
		this.pstmt.setString(3, class_attendance.getAttendance_address());
		this.pstmt.setDate(4, new java.sql.Date(class_attendance.getAttendance_time().getTime()));
		this.pstmt.setInt(5, class_attendance.getStudent_sum());
		this.pstmt.setInt(6, class_attendance.getStudent_realSum());
		this.pstmt.setInt(7, class_attendance.getNotSum());
		
		if(this.pstmt.executeUpdate() > 0){
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	//通过考勤编号修改信息
	public boolean doUpdateInfo(Class_attendance class_attendance,int attendance_id ) throws Exception {
		boolean flag = false;
		String sql = "update class_attendance attendance_id = ? ,class_id = ?,attendance_adrress = ?,attendance_time = ?,student_sum = ?,student_realSum = ?,student_notSum = ? whrere attendance_id = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(8, attendance_id);//设置考勤编号
		this.pstmt.setInt(1, class_attendance.getAttendance_id());
		this.pstmt.setInt(2, class_attendance.getClass_id());
		this.pstmt.setString(3, class_attendance.getAttendance_address());
		this.pstmt.setDate(4, new java.sql.Date(class_attendance.getAttendance_time().getTime()));
		this.pstmt.setInt(5, class_attendance.getStudent_sum());
		this.pstmt.setInt(6, class_attendance.getStudent_realSum());
		this.pstmt.setInt(7, class_attendance.getNotSum());
		if(this.pstmt.executeUpdate() > 0){
			flag =true;
		}
		this.pstmt.close();
		return flag;
	}

	//查询所有考勤记录
	public List<Class_attendance> findAll(String  keyWord) throws Exception {
		List<Class_attendance> all = new ArrayList<Class_attendance>();
		String sql = "select * from Class_attendance";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, keyWord);
		ResultSet rs = this.pstmt.executeQuery();
		Class_attendance class_attendance = null;
		while(rs.next()){
			class_attendance = new Class_attendance();
			class_attendance.setAttendance_id(rs.getInt(1));
			class_attendance.setClass_id(rs.getInt(2));
			class_attendance.setAttendance_address(rs.getString(3));
			class_attendance.setAttendance_time(rs.getDate(4));
			class_attendance.setStudent_sum(rs.getInt(5));
			class_attendance.setStudent_realSum(rs.getInt(6));
			class_attendance.setNotSum(rs.getInt(7));
			all.add(class_attendance);
		}
		this.pstmt.close();
		return all;
	}
	
	public Class_attendance findByld(int class_id) throws Exception{
		Class_attendance class_attendance = null;
		String sql = "select * from Class_attendance where class_id = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, class_id);
		ResultSet rs = this.pstmt.executeQuery();//执行查询操作
		if(rs.next()){
			class_attendance = new Class_attendance();
			class_attendance.setAttendance_id(rs.getInt(1));
			class_attendance.setClass_id(rs.getInt(2));
			class_attendance.setAttendance_address(rs.getString(3));
			class_attendance.setAttendance_time(rs.getDate(4));
			class_attendance.setStudent_sum(rs.getInt(5));
			class_attendance.setStudent_realSum(rs.getInt(6));
			class_attendance.setNotSum(rs.getInt(7));
		}
		this.pstmt.close();
		return class_attendance;
	}

}
