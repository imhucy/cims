package com.cims.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cims.dao.IActivityDAO;
import com.cims.vo.Activity;

public class ActivityDAOImpl implements IActivityDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public ActivityDAOImpl(Connection conn){
		this.conn = conn;
	}
	
	
	public boolean doAdd(Activity activity) throws Exception {
		boolean flag = false;
		String sql = "insert into activity(class_id,activity_name," +
				"activity_address,activity_time,activity_content) values(?,?,?,?,?);";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, activity.getClass_id());
		this.pstmt.setString(2, activity.getActivity_name());
		this.pstmt.setString(3, activity.getActivity_address());
		this.pstmt.setDate( 4, new java.sql.Date(activity.getActivity_time().getTime()) );
		this.pstmt.setString(5,activity.getActivity_content());
		
		if( this.pstmt.executeUpdate() > 0 ){
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	
	public List<Activity> findAll(int class_id) throws Exception {
		List<Activity> all = new ArrayList<Activity>();//���弯�ϣ��������
		String sql = "select * from activity where class_id = ?";
		this.pstmt = this.conn.prepareStatement(sql);//ʵ��PrepareStatement����
		this.pstmt.setInt(1, class_id);//���ð༶���
		ResultSet rs = this.pstmt.executeQuery();//ִ�в�ѯ����
		Activity activity = null;
		while(rs.next()){
			activity = new Activity();//ʵ��Activity����
			activity.setActivity_id(rs.getInt(1));
			activity.setClass_id(rs.getInt(2));
			activity.setActivity_name(rs.getString(3));
			activity.setActivity_address(rs.getString(4));
			activity.setActivity_time(rs.getDate(5));
			activity.setActivity_content(rs.getString(6));
			all.add(activity);
		}
		this.pstmt.close();
		return all;
		
	}
	public Activity findByld(int activity_id) throws Exception{
		Activity activity = null;//����activity����
		String sql = "select * from Activity where activity_id = ?";
		this.pstmt = this.conn.prepareStatement(sql);//ʵ��prepareStatement����
		this.pstmt.setInt(1, activity_id);//���û�ı��
		ResultSet rs = this.pstmt.executeQuery();//ִ�в�ѯ����
		if(rs.next()){//���Բ�ѯ���Ľ��
			activity = new Activity();//ʵ���µ�Activity����
			activity.setActivity_id(rs.getInt(1));
			activity.setClass_id(rs.getInt(2));
			activity.setActivity_name(rs.getString(3));
			activity.setActivity_address(rs.getString(4));
			activity.setActivity_time(rs.getDate(5));
			activity.setActivity_content(rs.getString(6));
			
		}
		this.pstmt.close();//�ر�prepareStatement����
		return activity;
	}

}
