package com.cims.dao;

import java.util.List;

import com.cims.vo.Course;

public interface ICourseDAO {
	public List<Course> findAll() throws Exception;
}
