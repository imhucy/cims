package com.cims.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cims.dao.IStudentDAO;
import com.cims.vo.Student;

public class StudentDAOImpl implements IStudentDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public StudentDAOImpl(Connection conn){
		this.conn = conn;
	}
	//����������������
	public boolean doAdd(Student student) throws Exception {
		boolean flag = false;
		String sql = "insert into student values(?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, student.getStudent_id());
		this.pstmt.setInt(2,student.getClass_id());
		this.pstmt.setInt(3,student.getPosion());
		this.pstmt.setString(4, student.getStudent_sex());
		this.pstmt.setString(5,student.getStudent_name());
		this.pstmt.setDate(6,new java.sql.Date(student.getStudent_birthday().getTime()));
		this.pstmt.setString(7,student.getTelephone());
		this.pstmt.setString(8, student.getPassword());
		
		if(this.pstmt.executeUpdate() > 0){
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	//��������������
	//������������������������
	public boolean doUpdateInfo(Student student,int student_id) throws Exception {
		boolean flag = false;//����������
		String sql = "update student set student_id = ?,class_id = ?,posion = ?,student_sex = ?,student_name = ?,student_birth = ?, telephone = ?,password = ?where student_id = ?";
		this.pstmt = this.conn.prepareStatement(sql);//������prepareStatement����
		this.pstmt.setInt(1, student.getStudent_id());//����student_id
		this.pstmt.setInt(2, student.getClass_id());//����class_id
		this.pstmt.setInt(3, student.getPosion());//����posion
		this.pstmt.setString(4,student.getStudent_sex());//����student_sex
		this.pstmt.setString(5, student.getStudent_name());//����student_name
		this.pstmt.setDate(6, new java.sql.Date(student.getStudent_birthday().getTime()));//����student_birthday
		this.pstmt.setString(7, student.getTelephone());//����telephone
		this.pstmt.setString(8, student.getPassword());//����password
		this.pstmt.setInt(9, student_id);//������������
		if(this.pstmt.executeUpdate() > 0){
			flag = true;
		}
		this.pstmt.close();//����prepareStatement����
		return flag;
	}

	//��������������������
	public Student findByld(int student_id) throws Exception {
		Student student = null;//����Student����
		String sql = "select * from student where student_id = ? ";
		this.pstmt = this.conn.prepareStatement(sql);//������prepareStatement����
		this.pstmt.setInt(1, student_id);//��������������
		ResultSet rs = this.pstmt.executeQuery();//������������
		if(rs.next()){//������������
			student = new Student();//����������Student����
			student.setStudent_id(rs.getInt(1));//����student_id������
			student.setClass_id(rs.getInt(2));//����class_id������
			student.setPosion(rs.getInt(3));//����posion������
			student.setStudent_sex(rs.getString(4));//����student_sex����
			student.setStudent_name(rs.getString(5));//����student_name����
			student.setStudent_birthday(rs.getDate(6));//����birthday����
			student.setTelephone(rs.getString(7));//����telephone����
			student.setPassword(rs.getString(8));//����password����
		}
		this.pstmt.close();//��������
		return student;
	}
	
	public List<Student> findAllByClassId(int class_id) throws Exception{
		List<Student> list = new ArrayList<Student>();
		
		String sql = "select * from student where class_id = ?;";
		
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, class_id);
		ResultSet rs = null;
		
		rs = this.pstmt.executeQuery();
		
		while (rs.next()){
			
			Student stu = new Student();
			stu.setClass_id( rs.getInt("class_id") );
			stu.setPassword(rs.getString("password"));
			stu.setPosion(rs.getInt("posion"));
			stu.setStudent_birthday(rs.getDate("student_birth"));
			stu.setStudent_id(rs.getInt("student_id"));
			stu.setStudent_name(rs.getString("student_name"));
			stu.setStudent_sex(rs.getString("student_sex"));
			stu.setTelephone(rs.getString("telephone"));
			list.add(stu);
		}
		this.pstmt.close();
		return list ;
	}
}
