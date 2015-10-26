package com.cims.factory;

import com.cims.dao.IActivityDAO;
import com.cims.dao.IClassDAO;
import com.cims.dao.IClass_attendanceDAO;
import com.cims.dao.IClass_costDAO;
import com.cims.dao.IClass_meetingDAO;
import com.cims.dao.ICourseDAO;
import com.cims.dao.INotificeDAO;
import com.cims.dao.IRoleDAO;
import com.cims.dao.IScoreDAO;
import com.cims.dao.IStu_attendanceDAO;
import com.cims.dao.IStudentDAO;
import com.cims.dao.proxy.ActivityDAOProxy;
import com.cims.dao.proxy.ClassDAOProxy;
import com.cims.dao.proxy.Class_attendanceDAOProxy;
import com.cims.dao.proxy.Class_costDAOProxy;
import com.cims.dao.proxy.Class_meetingDAOProxy;
import com.cims.dao.proxy.CourseDAOProxy;
import com.cims.dao.proxy.NotificeDAOProxy;
import com.cims.dao.proxy.RoleDAOProxy;
import com.cims.dao.proxy.ScoreDAOProxy;
import com.cims.dao.proxy.Stu_attendanceDAOProxy;
import com.cims.dao.proxy.StudentDAOProxy;

public class DAOFactory {
	
	public static IActivityDAO getIActivityDAOInstance() throws Exception{//����DAO��������
		
		return new ActivityDAOProxy();//��������������
	}
	public static IStu_attendanceDAO getIStu_attendanceDAOInstance() throws Exception{//����DAO��������
		
		return new Stu_attendanceDAOProxy();//��������������
	}
	public static INotificeDAO getINotificeDAOInscance() throws Exception{//����DAO��������
		return new NotificeDAOProxy();//��������������
	}
	public static IClass_meetingDAO getIClass_meetingDAOInstance() throws Exception{//����DAO��������
		return new Class_meetingDAOProxy();//��������������
	}
	public static IStudentDAO getIStudentDAOInstance() throws Exception{//����DAO��������
		return new StudentDAOProxy();//��������������
	}
	public static IScoreDAO getIScoreDAOInstance() throws Exception{
		return new ScoreDAOProxy();
	}
	public static IClass_attendanceDAO getIClass_attendanceDAOInstance() throws Exception{
		return new Class_attendanceDAOProxy();
	}
	public static IClass_costDAO getIClass_costDAOInstance() throws Exception{
		return new Class_costDAOProxy();
	}
	public static IRoleDAO getIRoleDAOInstance() throws Exception{
		return new RoleDAOProxy();
	}
	public static ICourseDAO getICourseDAOInstance() throws Exception{
		return new CourseDAOProxy();
	}
	public static IClassDAO getIClassDAOInstance() throws Exception{
		return new ClassDAOProxy();
	}
}
