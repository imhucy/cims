package com.cims.dao;

import java.util.List;

import com.cims.vo.Class_attendance;

public interface IClass_attendanceDAO {
	//¼����Ϣ
	public boolean doAdd(Class_attendance class_attendance) throws Exception;
	//�޸���Ϣ
	public boolean doUpdateInfo(Class_attendance class_attendance,int attendance_id) throws Exception;
	//ͨ���༶���ڰ�id�鿴��Ϣ
	public List<Class_attendance> findAll(String  keyword) throws Exception;
	//���ҹؼ���
	public  Class_attendance findByld(int class_id) throws Exception;
}
