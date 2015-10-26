package com.cims.dao.proxy;

import java.util.List;

import com.cims.dao.ICourseDAO;
import com.cims.dao.ICourseDAO;
import com.cims.dao.impl.CourseDAOImpl;
import com.cims.dbc.DatebaseConnection;
import com.cims.vo.Course;

public class CourseDAOProxy implements ICourseDAO {
	private DatebaseConnection dbc = null;
	private ICourseDAO dao = null;
	public CourseDAOProxy() throws Exception{
		this.dbc = new DatebaseConnection();
		this.dao = new CourseDAOImpl(this.dbc.getConnection());
	}
	public List<Course> findAll() throws Exception {
		List<Course> list = null;
		try {
			
			list = this.dao.findAll();
		
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		
		return list;
	}

}
