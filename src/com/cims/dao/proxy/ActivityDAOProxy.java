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
		this.dbc = new DatebaseConnection();//连接数据库
		this.dao = new ActivityDAOImpl(this.dbc.getConnection());//实例化真实主题类
		
	}
	public boolean doAdd(Activity activity) throws Exception {
		boolean flag = false;
		try {
			if(this.dao.findByld(activity.getActivity_id()) == null){//如果插入活动的编号不存在
				flag = this.dao.doAdd(activity);//调用真实主题操作
			}
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	
	public List<Activity> findAll(int keyWord) throws Exception {
		List<Activity> all = null;//定义返回的集合
		try {
			all = this.dao.findAll(keyWord);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();//关闭数据库
		}
		return all;
	}
	public Activity findByld(int activity_id) throws Exception{
		Activity activity = null;//定义Activity对象
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
