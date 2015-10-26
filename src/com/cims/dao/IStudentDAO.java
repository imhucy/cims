package com.cims.dao;

import java.util.List;

import com.cims.vo.Student;

public interface IStudentDAO {
	//��ɲ�����
	//��Ϣ�޸�
	public boolean doUpdateInfo(Student student,int student_id)throws Exception;
	//��Ϣ����
	public boolean doAdd(Student student )throws Exception;
	//ͨ�����ѧ��ѧ�Źؼ���
	public Student findByld(int student_id) throws Exception;
	
	public List<Student> findAllByClassId(int class_id) throws Exception;
}
