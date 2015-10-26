package com.cims.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cims.factory.DAOFactory;
import com.cims.vo.Score;

public class ScoreAdd extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int student_id = Integer.parseInt(request.getParameter("student_id"));
		int course_id = Integer.parseInt(request.getParameter("course_id"));
		int score = Integer.parseInt(request.getParameter("score"));
		
		Score scoreObj = new Score();
		scoreObj.setCourse_id(course_id);
		scoreObj.setScore(score);
		scoreObj.setStudent_id(student_id);
		
		try {
			if ( DAOFactory.getIScoreDAOInstance().doAdd(scoreObj) ){
				out.print("{\"msg\":\"插入成功\"}");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		out.flush();
		out.close();
	}

}
