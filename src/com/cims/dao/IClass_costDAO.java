package com.cims.dao;

import java.util.List;

import com.cims.vo.Class_cost;

public interface IClass_costDAO {
	//添加缴费记录insert
	public boolean doAdd(Class_cost class_cost) throws Exception;
	//添加支出记录update
	public boolean doUpdateInfo(Class_cost class_cos,int cost_id) throws Exception;
	//按班级查询所有收支记录
	public List<Class_cost> findAll(int class_id) throws Exception;
	//查找班级编号关键字
	public Class_cost findByld(int class_id) throws Exception;
	

}
