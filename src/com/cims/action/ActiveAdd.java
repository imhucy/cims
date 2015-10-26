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
import com.cims.vo.Activity;
import com.cims.vo.Class_cost;

public class ActiveAdd extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		/**
		 * 活动信息
		 */
		String str = request.getParameter("class_id");
		int class_id = Integer.parseInt( str ) ;
		String active_event = request.getParameter("active_event");
		String active_time = request.getParameter("active_time");
		String active_addr = request.getParameter("active_addr");
		String active_content = request.getParameter("active_content");
		/**
		 * 如果不是0的话要写入班费记录中
		 */
		float active_number = Float.parseFloat( request.getParameter("active_number") );
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		Date date = null;
		try {
			date = sdf.parse(active_time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Activity active = new Activity();
		
		active.setClass_id( class_id );
		active.setActivity_address( active_addr );
		active.setActivity_content( active_content );
		active.setActivity_name( active_event );
		active.setActivity_time( date );

		try {
			boolean b = DAOFactory.getIActivityDAOInstance().doAdd(active);
			System.out.print(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/**
		 * private int class_id;
		   private String cost_name;
		   private double cost_number;
		   private Date cost_time;
		 */
		
		if( active_number > 0 ){
			Class_cost class_cost = new Class_cost();
			class_cost.setClass_id( class_id );
			class_cost.setCost_name(active_event);
			class_cost.setCost_number(-active_number);
			class_cost.setCost_time(date);
			try {
				DAOFactory.getIClass_costDAOInstance().doAdd(class_cost);
				DAOFactory.getIClassDAOInstance().doUpdateSumMoney(class_id, -active_number);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		out.flush();
		out.close();
	}

}
