package com.cims.dao.proxy;

import java.util.List;

import com.cims.dao.IStudentDAO;
import com.cims.dao.impl.StudentDAOImpl;
import com.cims.dbc.DatebaseConnection;
import com.cims.vo.Student;

public class StudentDAOProxy implements IStudentDAO {

	private DatebaseConnection dbc = null;//������ݿ�����
	private IStudentDAO dao = null;//����DAO����
	public StudentDAOProxy() throws Exception{//�ڹ��췽����ʵ������ͬʱʵ��dao����
		this.dbc = new DatebaseConnection();//������ݿ�
		this.dao = new StudentDAOImpl(this.dbc.getConnection());//ʵ����ʵ�������
	}
	//���
	public boolean doAdd(Student student) throws Exception {
		boolean flag = false;
		try {
			if(this.dao.findByld(student.getStudent_id())== null){//���Ҫ�����ѧ���Ų�����
				flag = this.dao.doAdd(student);//���������������
			}
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	//����
	public boolean doUpdateInfo(Student student,int student_id) throws Exception {
		boolean flag = false;
		try {
			if(this.dao.findByld(student.getStudent_id()) != null){
				flag = this.dao.doUpdateInfo(student,student_id);//����������������
			}
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();//�ر���ݿ�
		}
		return flag;
	}

	//��ѯ
	public Student findByld(int student_id) throws Exception {
		Student student = null;//����Student����
		try{
			student = this.dao.findByld(student_id);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();//�ر���ݿ�
		}
		return student;
	}

	public List<Student> findAllByClassId(int class_id) throws Exception{
		List<Student> list = null;
		
		try {
			list = this.dao.findAllByClassId(class_id);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return list;
		
	}
}
