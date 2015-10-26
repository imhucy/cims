package com.cims.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cims.dao.IClass_costDAO;
import com.cims.vo.Class_cost;

public class Class_costDAOImpl implements IClass_costDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public Class_costDAOImpl(Connection conn) throws Exception{
		this.conn = conn;
	}
	//���ɷ���
	public boolean doAdd(Class_cost class_cost) throws Exception {
		boolean flag = false;
		String sql = "insert into class_cost(class_id,cost_name,cost_number,cost_time) " +
				"values(?,?,?,?);";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, class_cost.getClass_id());
		this.pstmt.setString(2, class_cost.getCost_name());
		this.pstmt.setDouble(3, class_cost.getCost_number());
		this.pstmt.setDate(4, new java.sql.Date(class_cost.getCost_time().getTime()));
		int t = this.pstmt.executeUpdate();
		
		if( t > 0 ){
			flag = true;
		}
		this.pstmt.close();
		
		return flag;
	}

	
	public boolean doUpdateInfo(Class_cost class_cost,int cost_id) throws Exception {
		boolean flag = false;
		String sql = "update class_cost set cost_id = ?,class_id = ?,cost_name = ?,cost_number = ?,cost_time = ? where cost_id = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(6, cost_id);
		this.pstmt.setInt(1, class_cost.getCost_id());
		this.pstmt.setInt(2, class_cost.getClass_id());
		this.pstmt.setString(3, class_cost.getCost_name());
		this.pstmt.setDouble(4, class_cost.getCost_number());
		this.pstmt.setDate(5, new java.sql.Date(class_cost.getCost_time().getTime()));
		if(this.pstmt.executeUpdate() > 0){
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	public List<Class_cost> findAll(int class_id) throws Exception {
		List<Class_cost> list = new ArrayList<Class_cost>();
		String sql = "select * from class_cost where class_id = ?;";
		this.pstmt  = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, class_id);
		ResultSet rs = this.pstmt.executeQuery();

		while(rs.next()){
			Class_cost class_cost = new Class_cost();
			class_cost.setCost_id(rs.getInt("cost_id"));
			class_cost.setClass_id(rs.getInt("class_id"));
			class_cost.setCost_name(rs.getString("cost_name"));
			class_cost.setCost_number(rs.getFloat("cost_number"));
			class_cost.setCost_time(rs.getDate("cost_time"));
			list.add(class_cost);
		}
		this.pstmt.close();
		return list;
	}

	
	public Class_cost findByld(int class_id) throws Exception {
		Class_cost class_cost = null;
		String sql = "select * from class_cost where class_id = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1,class_id);
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			class_cost = new Class_cost();
			class_cost.setCost_id(rs.getInt(1));
			class_cost.setClass_id(rs.getInt(2));
			class_cost.setCost_name(rs.getString(3));
			class_cost.setCost_number(rs.getDouble(4));
			class_cost.setCost_time(rs.getDate(5));
		}
		this.pstmt.close();
		return class_cost;
	}

}
