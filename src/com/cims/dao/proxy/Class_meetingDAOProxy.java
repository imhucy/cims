package com.cims.dao.proxy;

import java.util.List;

import com.cims.dao.IClass_meetingDAO;
import com.cims.dao.impl.Class_meetingDAOImpl;
import com.cims.dbc.DatebaseConnection;
import com.cims.vo.Class_meeting;

public class Class_meetingDAOProxy implements IClass_meetingDAO {

	private DatebaseConnection dbc= null;//定义数据库连接类
	private IClass_meetingDAO dao = null;//声明DAO对象
	public Class_meetingDAOProxy() throws Exception{//在构造方法中实例化连接，同时实例化dao对象
		this.dbc = new DatebaseConnection();//连接数据库
		this.dao = new Class_meetingDAOImpl(this.dbc.getConnection());//实例化真实主题操作
		
	}
	public boolean doAdd(Class_meeting class_meeting) throws Exception {
		boolean flag = false;//定义标示符
			try {
				if(this.dao.findByld(class_meeting.getMeeting_id()) == null){//如果要插入的班会编号不存在
					flag = this.dao.doAdd(class_meeting);//调用真正主题操作
					
				}
			} catch (Exception e) {
				throw e;
			}finally{
				this.dbc.close();//关闭数据库的连接
			}
		return flag;
	}

	public List<Class_meeting> findAll(int class_id) throws Exception {
		List<Class_meeting> all = null;//定义返回的集合
		try {
			all = this.dao.findAll(class_id);//调用真实主题
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return all;
	}

	public Class_meeting findByld(int meeting_id) throws Exception {
		Class_meeting class_meeting = null;//定义Class_meeting对象
		try {
			class_meeting = this.dao.findByld(meeting_id);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return class_meeting;
	}

}
