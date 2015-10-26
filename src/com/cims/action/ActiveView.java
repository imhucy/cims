package com.cims.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.CycleDetectionStrategy;

import com.cims.factory.DAOFactory;
import com.cims.vo.Activity;

public class ActiveView extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int class_id = Integer.parseInt( request.getParameter("class_id") );
		
		JsonConfig config=new JsonConfig();
        //设置循环策略为忽略
        config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
        //设置 json转换的处理器用来处理日期类型
        //凡是反序列化Date类型的对象，都会经过该处理器进行处理
        config.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {
            //参数1 ：属性名参数2：json对象的值参数3：jsonConfig对象
            public Object processObjectValue(String arg0, Object arg1,JsonConfig arg2) {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                Date d=(Date) arg1;
                return sdf.format(d);
            }
            public Object processArrayValue(Object arg0, JsonConfig arg1) {
                return null;
            }
        });
		try {
			List<Activity> list = DAOFactory.getIActivityDAOInstance().findAll(class_id);
			
			if(list != null){
				out.print( JSONArray.fromObject(list,config).toString() );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		out.flush();
		out.close();
	}

}
