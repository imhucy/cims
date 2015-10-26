package com.cims.dao;

import java.util.List;

import com.cims.vo.Class_meeting;

public interface IClass_meetingDAO {
	//记录班会
	public boolean doAdd(Class_meeting class_meeting) throws Exception;
	//通过班级id查看班会全部记录
	public List<Class_meeting> findAll(int class_id ) throws Exception;
	//查找班会id
	public Class_meeting findByld(int meeting_id ) throws Exception;
}
