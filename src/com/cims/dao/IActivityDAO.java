package com.cims.dao;

import java.util.List;

import com.cims.vo.Activity;

public interface IActivityDAO {
	//��ӻ
	public boolean doAdd(Activity activity) throws Exception;
	//ͨ���༶���������л
	public List<Activity> findAll(int class_id) throws Exception;
	//���ҹؼ���
	public Activity findByld(int activity_id) throws Exception;
		
}
