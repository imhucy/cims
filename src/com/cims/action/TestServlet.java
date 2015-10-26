package com.cims.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cims.factory.DAOFactory;
import com.cims.vo.Student;

public class TestServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			Student student = null;//����Student����
			student = new Student();
			student.setStudent_id(1);
			student.setClass_id(1);
			student.setPosion(2);
			student.setStudent_birthday(new java.util.Date());
			student.setPassword("123456");
			student.setStudent_name("����");
			student.setTelephone("123456");
			student.setStudent_sex("��");
			DAOFactory.getIStudentDAOInstance().doAdd(student);//ִ�в������
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		out.flush();
		out.close();
	}

}
