package com.cims.dao;

import java.util.List;

import com.cims.vo.Class_meeting;

public interface IClass_meetingDAO {
	//��¼���
	public boolean doAdd(Class_meeting class_meeting) throws Exception;
	//ͨ���༶id�鿴���ȫ����¼
	public List<Class_meeting> findAll(int class_id ) throws Exception;
	//���Ұ��id
	public Class_meeting findByld(int meeting_id ) throws Exception;
}
