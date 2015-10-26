package com.cims.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cims.factory.DAOFactory;
import com.cims.vo.Notifice;

public class NoticeAdd extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		int class_id = Integer.parseInt(request.getParameter("class_id"));
		String notifice_name = request.getParameter("notifice_name");
		String notifice_content = request.getParameter("notifice_content");
		
		Notifice notifice = new Notifice();
		
		notifice.setClass_id(class_id);
		notifice.setNotifice_content(notifice_content);
		notifice.setNotifice_name(notifice_name);
		
		
		try {
			DAOFactory.getINotificeDAOInscance().doAdd(notifice);
			out.print("{\"msg\":\"修改成功\"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		out.flush();
		out.close();
	}

}
