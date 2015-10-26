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
import com.cims.vo.Class_cost;

public class ClassCostAdd extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String cost_name = request.getParameter("cost_name");
		float cost_number = Float.parseFloat(request.getParameter("cost_number"));
		int class_id = Integer.parseInt(request.getParameter("class_id"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date cost_time = null;
		try {
			cost_time = sdf.parse(request.getParameter("cost_time"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Class_cost class_cost = new Class_cost();
		
		class_cost.setClass_id(class_id);
		class_cost.setCost_name(cost_name);
		class_cost.setCost_number(cost_number);
		class_cost.setCost_time(new java.sql.Date( cost_time.getTime() ) );
		
		try {
			boolean b = DAOFactory.getIClass_costDAOInstance().doAdd(class_cost);
			if ( b ){
				// 更新班费总额
				DAOFactory.getIClassDAOInstance().doUpdateSumMoney(class_id, cost_number);
				out.println("{\"msg\":\"添加成功\"}");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		out.flush();
		out.close();
	}

}
