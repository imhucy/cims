package com.cims.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cims.dao.IStudentDAO;
import com.cims.factory.DAOFactory;
import com.cims.vo.Student;

public class UpdateRole extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int student_id = Integer.parseInt( request.getParameter("student_id") );
		int role_id = Integer.parseInt( request.getParameter("student_role") );
		
		try {
			
			Student stu = DAOFactory.getIStudentDAOInstance().findByld(student_id);
			stu.setPosion(role_id);
			DAOFactory.getIStudentDAOInstance().doUpdateInfo(stu, student_id);
			out.print("{\"msg\":\"修改成功\"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		out.flush();
		out.close();
	}

}
