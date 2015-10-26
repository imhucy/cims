package com.cims.dao.proxy;

import java.util.ArrayList;
import java.util.List;

import com.cims.dao.IClass_attendanceDAO;
import com.cims.dao.impl.Class_attendanceDAOImpl;
import com.cims.dbc.DatebaseConnection;
import com.cims.vo.Class_attendance;

public class Class_attendanceDAOProxy implements IClass_attendanceDAO {

	private DatebaseConnection dbc = null;//定义数据库连接类
	private IClass_attendanceDAO dao = null;//声明DAO对象
	public Class_attendanceDAOProxy() throws Exception{
		this.dbc = new DatebaseConnection();
		this.dao = new Class_attendanceDAOImpl(this.dbc.getConnection());
	}
	
	public boolean doAdd(Class_attendance class_attendance) throws Exception {
		boolean flag = false;
		try {
			if(this.dao.findByld(class_attendance.getAttendance_id()) == null){
				flag = this.dao.doAdd(class_attendance);
			}
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	public boolean doUpdateInfo(Class_attendance class_attendance,int attendance_id) throws Exception {
		boolean flag = false;
		try {
			if(this.dao.findByld(class_attendance.getAttendance_id()) != null){
				flag = this.dao.doUpdateInfo(class_attendance, attendance_id);
			}
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	public List<Class_attendance> findAll(String keyword) throws Exception {
		 List<Class_attendance> all = new ArrayList<Class_attendance>();
		 try {
			all = this.dao.findAll(keyword);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}

	public Class_attendance findByld(int class_id) throws Exception {
		Class_attendance class_attendance = null;
		try{
			class_attendance = this.dao.findByld(class_id);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return class_attendance;
	}

}
