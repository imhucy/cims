package com.cims.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cims.dao.IClass_meetingDAO;
import com.cims.vo.Class_meeting;

public class Class_meetingDAOImpl implements IClass_meetingDAO {
	private Connection conn = null;//���ݿ����Ӷ���
	private PreparedStatement pstmt = null;//���ݿ��������
	public Class_meetingDAOImpl(Connection conn){//ͨ�����췽��ȡ�����ݿ������
		this.conn = conn;//ȡ�����ݿ������
	}
	//ʵ�ְ������
	public boolean doAdd(Class_meeting class_meeting) throws Exception {
		boolean flag = false;//�����ʶ��
		String sql = "insert into class_meeting values(?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);//ʵ����prepareStatement����
		this.pstmt.setInt(1, class_meeting.getMeeting_id());//����meeting_id
		this.pstmt.setInt(2, class_meeting.getClass_id());//����class_id
		this.pstmt.setString(3, class_meeting.getMeeting_name());//����meeting_name
		this.pstmt.setDate(4, new java.sql.Date(class_meeting.getMeeting_time().getTime()));//����meeting_time
		this.pstmt.setString(5, class_meeting.getMeeting_address());//����meeting_address
		this.pstmt.setString(6, class_meeting.getMeeting_content());//����meeting_content
		if(this.pstmt.executeUpdate() > 0){//���µ���������0
			flag = true;//�޸ı�־��
		}
		this.pstmt.close();//�ر�PreparedStatement����
		return flag;
	}

	//ʵ�ְ��ͨ���༶id�Ĳ�ѯ
	public List<Class_meeting> findAll(int class_id) throws Exception {
		List<Class_meeting> all = new ArrayList<Class_meeting>();//���弯�ϣ�����ȫ������
		String sql = "select * from class_meeting where class_id = ?";
		this.pstmt = this.conn.prepareStatement(sql);//ʵ����prepareStatement����
		this.pstmt.setInt(1, class_id);//���ò�ѯ�ؼ���
		ResultSet rs = this.pstmt.executeQuery();//ִ�в�ѯ����
		Class_meeting class_meeting = null;//����Class_meeting����
		while(rs.next()){//����ȡ��ÿһ������
			class_meeting = new Class_meeting();//ʵ�����µ�Class_meeting����
			class_meeting.setMeeting_id(rs.getInt(1));//����meeting_id����
			class_meeting.setClass_id(rs.getInt(2));//����class_id����
			class_meeting.setMeeting_name(rs.getString(3));//����meeting_name����
			class_meeting.setMeeting_time(rs.getDate(4));//����meeting_time����
			class_meeting.setMeeting_address(rs.getString(5));//����meeting_address����
			class_meeting.setMeeting_content(rs.getString(6));//����meeting_content����
			all.add(class_meeting);//�򼯺������Ӷ���
		}
		this.pstmt.close();
		return all;//����ȫ�����
	}

	//ʵ�ֲ�ѯĳ���ض�������
	public Class_meeting findByld(int class_id) throws Exception {
		Class_meeting class_meeting = null;//����Class_meeting����
		String sql = "select meeting_id from class_meeting where class_id = ? ";
		this.pstmt = this.conn.prepareStatement(sql);//ʵ����prepareStatement����
		this.pstmt.setInt(1, class_id);//���ò�ѯ�ؼ���
		ResultSet rs = this.pstmt.executeQuery();//ִ�в�ѯ����
		if(rs.next()){//���Բ�ѯ���Ľ��
			class_meeting = new Class_meeting();//ʵ�����µ�Class_meeting����
			class_meeting.setMeeting_id(rs.getInt(1));//����class_meeting�е�����	
		}
		this.pstmt.close();//�ر�PreparedStatement����
		return class_meeting;
	}

}
