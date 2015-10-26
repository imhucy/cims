package com.cims.dao.proxy;

import java.util.ArrayList;
import java.util.List;

import com.cims.dao.IRoleDAO;
import com.cims.dao.impl.RoleDAOImpl;
import com.cims.dbc.DatebaseConnection;
import com.cims.vo.Role;

public class RoleDAOProxy implements IRoleDAO {
	private DatebaseConnection dbc = null;
	private IRoleDAO dao = null;
	public RoleDAOProxy() throws Exception{
		this.dbc = new DatebaseConnection();
		this.dao = new RoleDAOImpl(this.dbc.getConnection());
	}
	public List<Role> findAll() throws Exception {
		List<Role> list = new ArrayList<Role>();
		
		try {
			list = this.dao.findAll();
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		
		return list;
	}

}
