package com.cims.dao;

import java.util.List;

import com.cims.vo.Activity;

public interface IActivityDAO {
	//添加活动
	public boolean doAdd(Activity activity) throws Exception;
	//通过班级号搜索所有活动
	public List<Activity> findAll(int class_id) throws Exception;
	//查找关键字
	public Activity findByld(int activity_id) throws Exception;
		
}
