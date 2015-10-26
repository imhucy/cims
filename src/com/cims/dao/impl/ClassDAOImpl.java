package com.cims.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.resource.cci.ResultSet;

import com.cims.dao.IClassDAO;


public class ClassDAOImpl implements IClassDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public ClassDAOImpl(Connection conn){
		this.conn = conn;
	}
	
	public boolean doUpdateSumMoney(int class_id, float sum) throws Exception {
		boolean flag = false;
		
		String sql = "UPDATE class SET sum_money = sum_money + (?) WHERE class_id = ?;";
		
		this.pstmt = this.conn.prepareStatement(sql);
		
		this.pstmt.setFloat(1, sum);
		this.pstmt.setInt(2, class_id);
		
		if( this.pstmt.executeUpdate() > 0){
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}
	
	
	public com.cims.vo.Class findById(int class_id) throws Exception{
		com.cims.vo.Class classes = new com.cims.vo.Class();
		
		String sql = "select * from class where class_id = ?";
		
		this.pstmt = this.conn.prepareStatement(sql);
		
		this.pstmt.setInt(1, class_id);
		
		java.sql.ResultSet rs = this.pstmt.executeQuery();
		
		while( rs.next() ){
			classes.setClass_id( rs.getInt("class_id") );
			classes.setClass_name( rs.getString("class_name") );
			classes.setSum_money( rs.getFloat("sum_money") );
		}
		
		return classes;
	}
}
