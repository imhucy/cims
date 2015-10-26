package com.cims.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.CycleDetectionStrategy;

import com.cims.factory.DAOFactory;
import com.cims.vo.Student;

public class Login extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String uname = request.getParameter("username");
		String psw = request.getParameter("psw");
		int student_id = Integer.parseInt( uname );
		
		try {
			Student stu = DAOFactory.getIStudentDAOInstance().findByld(student_id);
//			如果存在该学生，并且该学生的密码输入正确
			if(stu != null && stu.getPassword().equals(psw)){
				response.addCookie( new Cookie("username",stu.getStudent_id()+"" ));
				response.addCookie( new Cookie("psw",stu.getPassword() ));
				response.addCookie( new Cookie("class_id",stu.getClass_id()+"" ));
				response.sendRedirect("/cims/devoops/index.html");
			}else{
				response.sendRedirect("/cims/devoops/page_500.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		out.flush();
		out.close();
	}

}
