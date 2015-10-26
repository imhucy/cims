package com.cims.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cims.dao.ICourseDAO;
import com.cims.vo.Course;

public class CourseDAOImpl implements ICourseDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	
	public CourseDAOImpl(Connection conn){
		this.conn = conn;
	}
	public List<Course> findAll() throws Exception {
		
		List<Course> list = new ArrayList<Course>();
		
		String sql = "select * from course ;";
		
		this.pstmt = this.conn.prepareStatement(sql);
		
		ResultSet rs = this.pstmt.executeQuery();
		
		while(rs.next()){
			Course course = new Course();
			
			course.setCourse_id(rs.getInt("course_id"));
			course.setCourse_name(rs.getString("course_name"));
			
			list.add(course);
		}
		
		this.pstmt.close();
		
		return list;
	}

}
