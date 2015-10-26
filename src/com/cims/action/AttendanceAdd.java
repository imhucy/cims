package com.cims.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cims.factory.DAOFactory;
import com.cims.vo.Stu_attendance;

@SuppressWarnings("serial")
public class AttendanceAdd extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		int student_id = Integer.parseInt( request.getParameter("student_id") );
		int course_id = Integer.parseInt( request.getParameter("course_id") );
		int class_id = Integer.parseInt( request.getParameter("class_id") );
		
		String address= request.getParameter("address");
		String result = request.getParameter("result");
		
		
		Stu_attendance stu_attendance = new Stu_attendance();
		
		stu_attendance.setAddress(address);
		stu_attendance.setClass_id(class_id);
		stu_attendance.setCourse_id(course_id);
		stu_attendance.setResult(result);
		stu_attendance.setStudent_id(student_id);
		
		try {
			DAOFactory.getIStu_attendanceDAOInstance().doAdd(stu_attendance);
			out.print("{\"msg\":\"修改成功\"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		out.flush();
		out.close();
	}
}
