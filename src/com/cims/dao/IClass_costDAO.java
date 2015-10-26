package com.cims.dao;

import java.util.List;

import com.cims.vo.Class_cost;

public interface IClass_costDAO {
	//��ӽɷѼ�¼insert
	public boolean doAdd(Class_cost class_cost) throws Exception;
	//���֧����¼update
	public boolean doUpdateInfo(Class_cost class_cos,int cost_id) throws Exception;
	//���༶��ѯ������֧��¼
	public List<Class_cost> findAll(int class_id) throws Exception;
	//���Ұ༶��Źؼ���
	public Class_cost findByld(int class_id) throws Exception;
	

}
