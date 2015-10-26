package com.cims.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cims.factory.DAOFactory;
import com.cims.vo.Student;

public class StuSetInfo extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		/*获取参数*/
		int id = Integer.parseInt( request.getParameter("student_id") );
		String sex = request.getParameter("sex");
		String tel = request.getParameter("tel");
		String psw = request.getParameter("psw");
		String birthStr = request.getParameter("birth");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birth = null;
		try {
			birth = sdf.parse(birthStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		/*构建对象*/
		Student student = null;
		try {
			student = DAOFactory.getIStudentDAOInstance().findByld(id);
			student.setPassword(psw);
			student.setStudent_birthday(birth);
			student.setTelephone(tel);
			student.setStudent_sex(sex);
			DAOFactory.getIStudentDAOInstance().doUpdateInfo(student, id);
			out.println("{\"msg\":\"woo cao\"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		out.flush();
		out.close();
	}

}
