package com.cims.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cims.dao.IStu_attendanceDAO;
import com.cims.vo.Stu_attendance;

public class Stu_attendanceDAOImpl implements IStu_attendanceDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public Stu_attendanceDAOImpl(Connection conn){
		this.conn = conn;
	}
	
	
	public boolean doAdd(Stu_attendance stu_attendance) throws Exception {
		boolean flag = false;
		String sql = "insert into stu_attendance(class_id,student_id,course_id," +
				"address,time,result) values(?,?,?,?,now(),?);";
		
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, stu_attendance.getClass_id() );
		this.pstmt.setInt(2, stu_attendance.getStudent_id());
		this.pstmt.setInt(3, stu_attendance.getCourse_id() );
		this.pstmt.setString(4, stu_attendance.getAddress() );
		this.pstmt.setString(5, stu_attendance.getResult() );
		
		if( this.pstmt.executeUpdate() > 0 ){
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	public List<Stu_attendance> findAll(int class_id) throws Exception {
		List<Stu_attendance> all = new ArrayList<Stu_attendance>();//���弯�ϣ��������
		String sql = "select * from stu_attendance where class_id = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, class_id);
		ResultSet rs = this.pstmt.executeQuery();
		Stu_attendance stu_attendance = null;
		while(rs.next()){
			stu_attendance = new Stu_attendance();
			
			stu_attendance.setId( rs.getInt("id") );
			stu_attendance.setAddress( rs.getString("address") );
			stu_attendance.setClass_id(rs.getInt("class_id"));
			stu_attendance.setCourse_id(rs.getInt("course_id"));
			stu_attendance.setResult( rs.getString("result") );
			stu_attendance.setStudent_id( rs.getInt("id") );
			stu_attendance.setTime( rs.getDate("time") );
			
			all.add(stu_attendance);
		}
		this.pstmt.close();
		return all;
	}
	//	按id查询
	public Stu_attendance findById(int attendance_id) throws Exception{
		Stu_attendance stu_attendance = new Stu_attendance();
		
		String sql = "select * from stu_attendance where id = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, attendance_id);
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			stu_attendance.setId( rs.getInt("id") );
			stu_attendance.setAddress( rs.getString("address") );
			stu_attendance.setClass_id(rs.getInt("class_id"));
			stu_attendance.setCourse_id(rs.getInt("course_id"));
			stu_attendance.setResult( rs.getString("result") );
			stu_attendance.setStudent_id( rs.getInt("student_id") );
			stu_attendance.setTime( rs.getDate("time") );
		}
		this.pstmt.close();
		
		return stu_attendance;
		
	}
	// 更新考勤记录
	public boolean doUpdateAttendance(Stu_attendance stu_attendance) throws Exception{
		boolean flag = false;
		
		String sql = "update stu_attendance set class_id = ?,student_id = ?,course_id = ?," +
				"address = ?,time = ?,result = ? where id = ?;";
		
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, stu_attendance.getClass_id() );
		this.pstmt.setInt(2, stu_attendance.getStudent_id());
		this.pstmt.setInt(3, stu_attendance.getCourse_id() );
		this.pstmt.setString(4, stu_attendance.getAddress() );
		this.pstmt.setDate(5, new java.sql.Date(stu_attendance.getTime().getTime()) );
		this.pstmt.setString(6, stu_attendance.getResult() );
		this.pstmt.setInt( 7, stu_attendance.getId() );
		
		if( this.pstmt.executeUpdate() > 0 ){
			flag = true;
		}
		this.pstmt.close();
		
		return flag;
	}
}
