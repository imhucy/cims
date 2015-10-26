package com.cims.dao.proxy;

import java.util.List;

import com.cims.dao.IActivityDAO;
import com.cims.dao.impl.ActivityDAOImpl;
import com.cims.dbc.DatebaseConnection;
import com.cims.vo.Activity;

public class ActivityDAOProxy implements IActivityDAO {

	private DatebaseConnection dbc = null;
	private IActivityDAO dao = null;
	public ActivityDAOProxy() throws Exception{
		this.dbc = new DatebaseConnection();//�������ݿ�
		this.dao = new ActivityDAOImpl(this.dbc.getConnection());//ʵ������ʵ������
		
	}
	public boolean doAdd(Activity activity) throws Exception {
		boolean flag = false;
		try {
			if(this.dao.findByld(activity.getActivity_id()) == null){//��������ı�Ų�����
				flag = this.dao.doAdd(activity);//������ʵ�������
			}
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	
	public List<Activity> findAll(int keyWord) throws Exception {
		List<Activity> all = null;//���巵�صļ���
		try {
			all = this.dao.findAll(keyWord);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();//�ر����ݿ�
		}
		return all;
	}
	public Activity findByld(int activity_id) throws Exception{
		Activity activity = null;//����Activity����
		try {
			activity = this.dao.findByld(activity_id);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return activity;
	}
	

}
