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
import com.cims.vo.Class_meeting;

public class ClassMeetingAdd extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int class_id = Integer.parseInt( request.getParameter("class_id") );
		
		String meeting_address = request.getParameter("class_meeting_address");
		
		String meeting_content = request.getParameter("class_meeting_content");
		
		String meeting_name    = request.getParameter("class_meeting_theme");
		
		SimpleDateFormat sdf   = new SimpleDateFormat("yyyy-MM-dd");
		Date meeting_time      = null;
		try {
			meeting_time = sdf.parse( request.getParameter("class_meeting_time") );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Class_meeting class_meeting = new Class_meeting();
		
		class_meeting.setClass_id(class_id);
		class_meeting.setMeeting_address(meeting_address);
		class_meeting.setMeeting_content(meeting_content);
		class_meeting.setMeeting_name(meeting_name);
		class_meeting.setMeeting_time( new java.sql.Date( meeting_time.getTime() ) );
		try {
			DAOFactory.getIClass_meetingDAOInstance().doAdd( class_meeting );
			out.println("{\"msg\":\"插入成功\"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		out.flush();
		out.close();
	}

}
