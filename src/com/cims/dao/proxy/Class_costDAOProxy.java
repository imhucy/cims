package com.cims.dao.proxy;

import java.util.List;

import com.cims.dao.IClass_costDAO;
import com.cims.dao.impl.Class_costDAOImpl;
import com.cims.dbc.DatebaseConnection;
import com.cims.vo.Class_cost;

public class Class_costDAOProxy implements IClass_costDAO {

	private DatebaseConnection dbc = null;//������ݿ�������
	private IClass_costDAO dao = null;//����DAO����
	public Class_costDAOProxy() throws Exception{
		this.dbc = new DatebaseConnection();
		this.dao = new Class_costDAOImpl(this.dbc.getConnection());
	}
	public boolean doAdd(Class_cost class_cost) throws Exception {
		boolean flag = false;
		try {
			
			flag = this.dao.doAdd(class_cost);
			
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	public boolean doUpdateInfo(Class_cost class_cost, int cost_id) throws Exception {
		boolean flag = false;
		try {
			if(this.dao.findByld(class_cost.getCost_id()) != null){
				flag = this.dao.doUpdateInfo(class_cost, cost_id);
			}
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	public List<Class_cost> findAll(int class_id) throws Exception {
		List<Class_cost> list = null ;
		
		try {
			list = this.dao.findAll(class_id);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		
		return list;
	}

	public Class_cost findByld(int class_id) throws Exception {
		Class_cost class_cost = null;
		
		try {
			class_cost = this.dao.findByld(class_id);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		
		return class_cost;
	}

}
