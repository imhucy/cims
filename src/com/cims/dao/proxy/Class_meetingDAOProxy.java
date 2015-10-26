package com.cims.dao.proxy;

import java.util.List;

import com.cims.dao.IClass_meetingDAO;
import com.cims.dao.impl.Class_meetingDAOImpl;
import com.cims.dbc.DatebaseConnection;
import com.cims.vo.Class_meeting;

public class Class_meetingDAOProxy implements IClass_meetingDAO {

	private DatebaseConnection dbc= null;//�������ݿ�������
	private IClass_meetingDAO dao = null;//����DAO����
	public Class_meetingDAOProxy() throws Exception{//�ڹ��췽����ʵ�������ӣ�ͬʱʵ����dao����
		this.dbc = new DatebaseConnection();//�������ݿ�
		this.dao = new Class_meetingDAOImpl(this.dbc.getConnection());//ʵ������ʵ�������
		
	}
	public boolean doAdd(Class_meeting class_meeting) throws Exception {
		boolean flag = false;//�����ʾ��
			try {
				if(this.dao.findByld(class_meeting.getMeeting_id()) == null){//���Ҫ����İ���Ų�����
					flag = this.dao.doAdd(class_meeting);//���������������
					
				}
			} catch (Exception e) {
				throw e;
			}finally{
				this.dbc.close();//�ر����ݿ������
			}
		return flag;
	}

	public List<Class_meeting> findAll(int class_id) throws Exception {
		List<Class_meeting> all = null;//���巵�صļ���
		try {
			all = this.dao.findAll(class_id);//������ʵ����
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return all;
	}

	public Class_meeting findByld(int meeting_id) throws Exception {
		Class_meeting class_meeting = null;//����Class_meeting����
		try {
			class_meeting = this.dao.findByld(meeting_id);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return class_meeting;
	}

}
