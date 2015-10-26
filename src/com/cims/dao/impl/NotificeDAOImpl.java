package com.cims.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cims.dao.INotificeDAO;
import com.cims.vo.Notifice;

public class NotificeDAOImpl implements INotificeDAO {
	private Connection conn = null;//��ݿ����Ӷ���
	private PreparedStatement pstmt = null;//��ݿ��������
	public NotificeDAOImpl(Connection conn){//ͨ���췽��ȡ����ݿ������
		this.conn = conn;//ȡ����ݿ������
	}
	//ʵ��֪ͨ�ķ���
	public boolean doAdd(Notifice notifice) throws Exception {
		boolean flag = false;//�����־��
		String sql = "insert into notifice(class_id ,notifice_name,notifice_content,notifice_time) values(?,?,?,now())";
		this.pstmt = this.conn.prepareStatement(sql);
		
		this.pstmt.setInt(1, notifice.getClass_id());
		this.pstmt.setString(2, notifice.getNotifice_name());
		this.pstmt.setString(3, notifice.getNotifice_content());
		
		if(this.pstmt.executeUpdate() > 0){
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}


	public List<Notifice> findAll(int class_id) throws Exception {
		List<Notifice> all = new  ArrayList<Notifice>();
		String sql = "select * from notifice where class_id = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, class_id);
		ResultSet rs = this.pstmt.executeQuery();
		Notifice notifice = null;
		while(rs.next()){
			notifice = new Notifice();
			notifice.setNotifice_id(rs.getInt(1));
			notifice.setClass_id(rs.getInt(2));
			notifice.setNotifice_name(rs.getString(3));
			notifice.setNotifice_content(rs.getString(4));
			notifice.setNotifice_time(rs.getDate(5));
			all.add(notifice);//�򼯺������Ӷ���
			
		}
		this.pstmt.close();
		return all;//����ȫ�����
	}


	public Notifice findByld(int class_id) throws Exception {
		Notifice notifice = null;
		String sql = "select notifice_id from notifice where class_id = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, class_id);
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			notifice = new Notifice();
			notifice.setNotifice_id(rs.getInt(1));
			
		}
		this.pstmt.close();
		return notifice;
	}

}
