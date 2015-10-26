package com.cims.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cims.dao.IRoleDAO;
import com.cims.vo.Role;

public class RoleDAOImpl implements IRoleDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public RoleDAOImpl(Connection conn){
		this.conn = conn;
	}
	
	public List<Role> findAll() throws Exception {
		
		List<Role> list = new ArrayList<Role>();
		
		String sql = "select * from role";
		
		this.pstmt = this.conn.prepareStatement(sql);
		
		ResultSet rs = this.pstmt.executeQuery();
		
		while(rs.next()){
			Role role = new Role();
			role.setName(rs.getString("name"));
			role.setRole_id(rs.getInt("role_id"));
			list.add(role);
		}
		
		this.pstmt.close();
		return list;
	}

}

