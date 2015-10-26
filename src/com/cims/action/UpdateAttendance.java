package com.cims.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cims.factory.DAOFactory;
import com.cims.vo.Stu_attendance;

public class UpdateAttendance extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		int student_id = Integer.parseInt( request.getParameter("student_id") );
		int attendance_id = Integer.parseInt( request.getParameter("attendance_id") );
		String result = request.getParameter("result");
		
		try {
			Stu_attendance stu_attendance = DAOFactory.getIStu_attendanceDAOInstance().findById(attendance_id);
			
			stu_attendance.setResult( result );
			
			if ( DAOFactory.getIStu_attendanceDAOInstance().doUpdateAttendance(stu_attendance) ){
				out.print("{\"msg\":\"修改成功\"}");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		out.flush();
		out.close();
	}

}
