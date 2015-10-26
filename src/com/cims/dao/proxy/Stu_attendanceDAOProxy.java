package com.cims.dao.proxy;

import java.util.List;


import com.cims.dao.IStu_attendanceDAO;
import com.cims.dao.impl.Stu_attendanceDAOImpl;
import com.cims.dbc.DatebaseConnection;
import com.cims.vo.Stu_attendance;

public class Stu_attendanceDAOProxy implements IStu_attendanceDAO {
	private DatebaseConnection dbc = null;
	private IStu_attendanceDAO dao = null;
	public Stu_attendanceDAOProxy() throws Exception{
		this.dbc = new DatebaseConnection();
		this.dao = new Stu_attendanceDAOImpl( this.dbc.getConnection() );
	}
	public boolean doAdd(Stu_attendance stu_attendance) throws Exception {
		boolean flag = false;
		try {
			
			flag = this.dao.doAdd(stu_attendance);
			
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	public List<Stu_attendance> findAll(int class_id) throws Exception {
		List<Stu_attendance> all = null;
		try {
			all = this.dao.findAll(class_id);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}
//	按id查询
	public Stu_attendance findById(int attendance_id) throws Exception{
		Stu_attendance stu_attendance = null;
		
		try {
			stu_attendance = this.dao.findById(attendance_id);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		
		return stu_attendance;
	}
	// 更新考勤记录
	public boolean doUpdateAttendance(Stu_attendance stu_attendance) throws Exception{
		boolean flag = false;
		
		try {
			flag = this.dao.doUpdateAttendance(stu_attendance);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		
		return flag;
	}
}
