package com.cims.dao.proxy;

import com.cims.dao.IClassDAO;
import com.cims.dao.IClassDAO;
import com.cims.dao.impl.ClassDAOImpl;
import com.cims.dbc.DatebaseConnection;
import com.cims.vo.Class;

public class ClassDAOProxy implements IClassDAO {
	private DatebaseConnection dbc = null;
	private IClassDAO dao = null;
	public ClassDAOProxy() throws Exception{
		this.dbc = new DatebaseConnection();
		this.dao = new ClassDAOImpl(this.dbc.getConnection());
		
	}
	public boolean doUpdateSumMoney(int class_id, float sum) throws Exception {
		boolean flag = false;
		
		try {
			flag = this.dao.doUpdateSumMoney(class_id, sum);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		
		return true;
	}
	public Class findById(int class_id) throws Exception {
		com.cims.vo.Class classes = new com.cims.vo.Class();
		
		try {
			classes = this.dao.findById(class_id);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		
		return classes;
	}

}
