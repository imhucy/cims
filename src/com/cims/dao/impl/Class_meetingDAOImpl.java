package com.cims.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cims.dao.IClass_meetingDAO;
import com.cims.vo.Class_meeting;

public class Class_meetingDAOImpl implements IClass_meetingDAO {
	private Connection conn = null;//数据库连接对象
	private PreparedStatement pstmt = null;//数据库操作对象
	public Class_meetingDAOImpl(Connection conn){//通过构造方法取得数据库的连接
		this.conn = conn;//取得数据库的连接
	}
	//实现班会的添加
	public boolean doAdd(Class_meeting class_meeting) throws Exception {
		boolean flag = false;//定义标识符
		String sql = "insert into class_meeting values(?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);//实例化prepareStatement对象
		this.pstmt.setInt(1, class_meeting.getMeeting_id());//设置meeting_id
		this.pstmt.setInt(2, class_meeting.getClass_id());//设置class_id
		this.pstmt.setString(3, class_meeting.getMeeting_name());//设置meeting_name
		this.pstmt.setDate(4, new java.sql.Date(class_meeting.getMeeting_time().getTime()));//设置meeting_time
		this.pstmt.setString(5, class_meeting.getMeeting_address());//设置meeting_address
		this.pstmt.setString(6, class_meeting.getMeeting_content());//设置meeting_content
		if(this.pstmt.executeUpdate() > 0){//更新的行数大于0
			flag = true;//修改标志符
		}
		this.pstmt.close();//关闭PreparedStatement操作
		return flag;
	}

	//实现班会通过班级id的查询
	public List<Class_meeting> findAll(int class_id) throws Exception {
		List<Class_meeting> all = new ArrayList<Class_meeting>();//定义集合，接收全部数据
		String sql = "select * from class_meeting where class_id = ?";
		this.pstmt = this.conn.prepareStatement(sql);//实例化prepareStatement对象
		this.pstmt.setInt(1, class_id);//设置查询关键字
		ResultSet rs = this.pstmt.executeQuery();//执行查询操作
		Class_meeting class_meeting = null;//定义Class_meeting对象
		while(rs.next()){//依次取出每一条数据
			class_meeting = new Class_meeting();//实例化新的Class_meeting对象
			class_meeting.setMeeting_id(rs.getInt(1));//设置meeting_id内容
			class_meeting.setClass_id(rs.getInt(2));//设置class_id内容
			class_meeting.setMeeting_name(rs.getString(3));//设置meeting_name内容
			class_meeting.setMeeting_time(rs.getDate(4));//设置meeting_time内容
			class_meeting.setMeeting_address(rs.getString(5));//设置meeting_address内容
			class_meeting.setMeeting_content(rs.getString(6));//设置meeting_content内容
			all.add(class_meeting);//向集合中增加对象
		}
		this.pstmt.close();
		return all;//返回全部结果
	}

	//实现查询某个特定的属性
	public Class_meeting findByld(int class_id) throws Exception {
		Class_meeting class_meeting = null;//声明Class_meeting对象
		String sql = "select meeting_id from class_meeting where class_id = ? ";
		this.pstmt = this.conn.prepareStatement(sql);//实例化prepareStatement对象
		this.pstmt.setInt(1, class_id);//设置查询关键字
		ResultSet rs = this.pstmt.executeQuery();//执行查询操作
		if(rs.next()){//可以查询到的结果
			class_meeting = new Class_meeting();//实例化新的Class_meeting对象
			class_meeting.setMeeting_id(rs.getInt(1));//设置class_meeting中的内容	
		}
		this.pstmt.close();//关闭PreparedStatement操作
		return class_meeting;
	}

}
